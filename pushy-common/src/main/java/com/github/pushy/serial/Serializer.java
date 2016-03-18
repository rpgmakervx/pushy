package com.github.pushy.serial;/**
 * Description : Serializer
 * Created by YangZH on 2016/3/11 0011
 *  23:08
 */

import com.github.pushy.util.Constants;
import io.netty.buffer.ByteBuf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description : Serializer
 * Created by YangZH on 2016/3/11 0011
 * 23:08
 * 包含一对读写ByteBuf,以及对各种类型的读写方法。
 * 开放write read方法给客户端自定义读写实现,
 * 读写数据的顺序务必一直，都则肯定会出错
 *
 * serializer对基本类型数据的序列化没有修饰，但是对String,List,Map,Serializer子类等类型数据进行了包装。
 * String，List，Map类型数据在ByteBuf中以一个short 2字节打头表示字符串长度、List长度、Map中键值对个数，
 * Serializer子类则用一个byte表示对象是否为空（0无1有）。
 * 上述修饰在writeXXX中均有体现（在正式读取写入数据之前都要先拿一下数据头，顺序一定是这样否则会错）
 */

abstract public class Serializer {

    private ByteBuf readBuffer;
    private ByteBuf writeBuffer;

    abstract public void write();
    abstract public void read();

    /**
     * 读取int类型
     * @return
     */
    public Integer readInt(){
        if(readBuffer.isReadable()){
            return readBuffer.readInt();
        }
        return 0;
    }

    /**
     * 读取float类型
     * @return
     */
    public Float readFloat(){
        if(readBuffer.isReadable()){
            return readBuffer.readFloat();
        }
        return 0f;
    }

    /**
     * 读取double类型
     * @return
     */
    public Double readDouble(){
        if(readBuffer.isReadable()){
            return readBuffer.readDouble();
        }
        return 0.0;
    }

    /**
     * 读取boolean类型
     * @return
     */
    public Boolean readBoolean(){
        if(readBuffer.isReadable()){
            return readBuffer.readBoolean();
        }
        return false;
    }

    /**
     * 读取short类型
     * @return
     */
    public Short readShort(){
        if(readBuffer.isReadable()){
            return readBuffer.readShort();
        }
        return (short)0;
    }

    /**
     * 读取long类型
     * @return
     */
    public Long readLong(){
        if(readBuffer.isReadable()){
            return readBuffer.readLong();
        }
        return (long)0;
    }

    /**
     * 读取byte类型
     * @return
     */
    public Byte readByte(){
        if(readBuffer.isReadable()){
            return readBuffer.readByte();
        }
        return (byte)0;
    }

    /**
     * 读取char类型数据
     * @return
     */
    public Character readChar(){
        if(readBuffer.isReadable()){
            return readBuffer.readChar();
        }
        return (char)0;
    }

    /**
     * 读取字符串，字符串头用一个short代表其长度，
     * 注意先读取其长度否则会出现读写数据不一致
     * @return
     */
    public String readString(){
        int size = readBuffer.readShort();
        if(size<=0){
            return "";
        }
        byte[] bytes = new byte[size];
        readBuffer.readBytes(bytes);
        return new String(bytes, Constants.CharsetClass.UTF8);
    }

    public <T> T read(Class<T> clazz){
        System.out.println("读取serializer类型对象："+clazz.getSimpleName());
        Object obj = null;
        if(clazz == Integer.class||clazz == int.class){
            obj = readInt();
        }else if(clazz == Float.class||clazz ==float.class){
            obj = readFloat();
        }else if(clazz == Double.class||clazz == double.class){
            obj = readDouble();
        }else if(clazz == Short.class||clazz == short.class){
            obj = readShort();
        }else if(clazz == Character.class||clazz == char.class){
            obj = readChar();
        }else if (clazz == String.class){
            obj = readString();
        }else if (clazz == Byte.class||clazz == byte.class){
            obj = readByte();
        } else if (clazz == long.class || clazz == Long.class){
            obj = this.readLong();
        } else if (clazz == boolean.class || clazz == Boolean.class){
            obj = this.readBoolean();
        } else if(Serializer.class.isAssignableFrom(clazz)){
            byte hasObject = readByte();
            if(hasObject==1){
                try {
                    //没有具体的实现类，用反射生成，然后复制当前对象的buffer，再读取对象
                    Serializer serializer = (Serializer) clazz.newInstance();
                    serializer.readFromBuffer(this.readBuffer);
                    obj = serializer;
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }else{
            throw new RuntimeException("未知的类型,或者对象必须实现"+this.getClass().getName());
        }
        return (T)obj;

    }

    /**
     * 读取一个list,需要知道list内容类型
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> List<T> readList(Class<T> clazz){
        List<T> list = new ArrayList<T>();
        int size = this.readBuffer.readShort();
        for(int i=0;i<size;i++){
            list.add(read(clazz));
        }
        return list;
    }

    /**
     * 读取一个map,需要知道key value类型
     * @param k_clazz
     * @param v_clazz
     * @param <K>
     * @param <V>
     * @return
     */
    public <K,V> Map<K,V> readMap(Class<K> k_clazz,Class<V> v_clazz){
        Map<K,V> obj = new HashMap<K, V>();
        int size = readShort();
        for(int i=0;i<size;i++){
            K key = read(k_clazz);
            V value = read(v_clazz);
            obj.put(key, value);
        }
        return obj;
    }

    /**
     * 写入int类型数据
     * @param data
     */
    public void writeInt(Integer data){
        this.writeBuffer.writeInt(data);
    }

    /**
     * 写入short类型数据
     * @param data
     */
    public void writeShort(Short data){
        this.writeBuffer.writeShort(data);
    }

    /**
     * 写入long类型数据
     * @param data
     */
    public void writeLong(Long data){
        this.writeLong(data);
    }

    /**
     *
     * @param data
     */
    public void writeChar(Character data){
        this.writeChar(data);
    }

    /**
     * 写入float类型数据
     * @param data
     */
    public void writeFloat(Float data){
        this.writeFloat(data);
    }

    /**
     * 写入double类型数据
     * @param data
     */
    public void writeDouble(Double data){
        this.writeDouble(data);
    }

    /**
     * 写入boolean类型数据
     * @param data
     */
    public void writeBoolean(Boolean data){
        this.writeBoolean(data);
    }

    public void writeByte(Byte data){
        this.writeBuffer.writeByte(data);
    }

    public void writeBytes(Byte[] bytes){
        this.writeBytes(bytes);
    }
    /**
     * 写入字符串数据，字符串头用一个short代表其长度
     * 注意先设置字符串长度，再设置字符串值，读取端也是先长度后值
     * @param data
     */
    public void writeString(String data){
        if(data==null||data.isEmpty()){
            writeShort((short)0);
            return;
        }
        writeShort((short)data.length());
        writeBuffer.writeBytes(data.getBytes(Constants.CharsetClass.UTF8));
    }

    /**
     * 写集合类型时需要添加clazz参数,非集合类型设置为null
     * @param obj
     */
    public void write(Object obj){
        if(obj == null){
            writeByte((byte) 0);
            return ;
        }else if (obj instanceof Integer ){
            writeInt((Integer)obj);
        }else if(obj instanceof Float){
            writeFloat((Float) obj);
        }else if(obj instanceof Double){
            writeDouble((Double) obj);
        }else if(obj instanceof Character){
            writeChar((Character) obj);
        }else if (obj instanceof Long){
            writeLong((Long) obj);
        }else if(obj instanceof Short){
            writeShort((Short) obj);
        }else if (obj instanceof Boolean){
            writeBoolean((Boolean) obj);
        }else if(obj instanceof String){
            writeString((String) obj);
        }else if (obj instanceof Byte){
            writeByte((Byte) obj);
        }else if(obj instanceof Serializer){
            writeByte((byte)1);
            Serializer serializer = (Serializer) obj;
            serializer.writeToTargetBuffer(writeBuffer);
        }else throw new RuntimeException("未知的类型,或者对象必须实现"+this.getClass().getName());
    }

    /**
     * 写入一个list
     * @param list
     * @param <T>
     */
    public <T> void writeList(List<T> list){
        if(list==null||list.isEmpty()){
            writeShort((short)0);
            return ;
        }
        short size = (short) list.size();
        writeShort(size);
        for(T item:list){
            write(item);
        }
    }


    public <K,V> void writeMap(Map<K,V> map){
        if(map==null||map.isEmpty()){
            writeShort((short)0);
            return ;
        }else{
            short size = (short) map.size();
            writeShort(size);
            for(Map.Entry<K, V> entry : map.entrySet()){
                write(entry.getKey());
                write(entry.getValue());
            }
        }
    }

    /**
     * 从字节数组中复制数据到本地buffer
     * @param bytes 目标字节数据
     */
    public void readFromBytes(byte[] bytes){
        this.readBuffer = BufferFactory.getBuffer(bytes);
        read();
    }

    /**
     *从buffer中复制数据到本地buffer
     * @param buffer 目标字节数据
     */
    public void readFromBuffer(ByteBuf buffer){
        this.readBuffer = buffer;
        read();
    }

    /**
     * 初始化本地buffer并写入本地
     */
    public void writeToLocalBuffer(){
        this.writeBuffer = BufferFactory.getBuffer();
        write();
    }

    /**
     * 从目标buffer复制到本地buffer，然后写入本地
     * @param buffer
     */
    public void writeToTargetBuffer(ByteBuf buffer){
        this.writeBuffer = buffer;
        write();
    }

    /**
     * 获取对象序列化后的字节数组
     * @return
     */
    public byte[] getBytes(){
        writeToLocalBuffer();
        byte[] bytes = null;
        if(writeBuffer.writerIndex()==0){
            bytes = new byte[0];
        }else{
            bytes = new byte[writeBuffer.writerIndex()];
            writeBuffer.readBytes(bytes);
        }
        return bytes;
    }

}
