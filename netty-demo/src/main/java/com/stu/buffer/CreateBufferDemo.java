package com.stu.buffer;

import java.nio.ByteBuffer;

/**
 * ByteBuffer
 *
 * @Author wangyixing
 * @Description
 */
public class CreateBufferDemo {
    public static void main(String[] args) {
        int capacity = 5;
        ByteBuffer allocate = ByteBuffer.allocate(capacity);
        for (int i = 0; i < capacity; i++) {
            //从缓冲区获取数据，不能超过capacity的长度
            System.out.println(allocate.get());
        }

        ByteBuffer wrap = ByteBuffer.wrap("zhang".getBytes());
        for (int i = 0; i < capacity; i++) {
            //从缓冲区获取数据，不能超过wrap内容的长度
            System.out.println(wrap.get());
        }
    }
}
