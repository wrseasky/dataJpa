package com.baidu.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.ReferenceCountUtil;

/**
* @author 作者 wr:
* @version 创建时间：2018年3月22日 下午3:11:11
* 类说明
*/
public class ClientHandler extends ChannelHandlerAdapter {  
	  
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {  
        try {  
            ByteBuf buf = (ByteBuf) msg;  
            byte[] data = new byte[buf.readableBytes()];  
            buf.readBytes(data);  
            System.out.println("Client：" + new String(data).trim());  
        } finally {  
            ReferenceCountUtil.release(msg);  
        }  
    }  
  
  
    @Override  
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {  
        cause.printStackTrace();  
        ctx.close();  
    }  
  
} 
