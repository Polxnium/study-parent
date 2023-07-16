package com.stu.jse.object;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author 86177
 */
public class Current extends Parent {
    private int size;
    private boolean off;
    public static void main(String[] args) {
        Current obj = new Current();
        int hashCode = obj.hashCode();
        //16进制输出对象HashCode, 对比头信息中HashCode
        String hex = Integer.toHexString(hashCode);
        System.out.println("HashCode: "+hashCode+", Hex HashCode: "+hex);
        System.err.println(ClassLayout.parseInstance(obj).toPrintable());
    }
}