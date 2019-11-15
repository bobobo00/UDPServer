package UDP;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 接收端
 * 1，使用DatagramSocket 指定端口，创建接收端。
 * 2，准备容器，封装成DatagramPacket包裹
 * 3，阻塞式接收包裹
 * 4，分析数据
 * 5，释放资源
 * 
 * @author dell
 *
 */

public class UDPServer {
	public static void main(String[] args) throws Exception {
		System.out.println("接收方启动中....");
		//使用DatagramSocket 指定端口，创建接收端
		DatagramSocket server=new DatagramSocket(6666);
		
		//分析数据
		/*ByteArrayInputStream is=new ByteArrayInputStream(packet.getData());
		OutputStream os=new BufferedOutputStream(new FileOutputStream(new File("copy.jpg")));
		byte[] flush=new byte[1024];
		while(is.read(flush)!=-1) {
			os.write(flush);
		}
		os.flush();*/
		while(true) {
			//准备容器，封装成DatagramPacket包裹
			byte[] datas=new byte[1024*60];
			DatagramPacket packet=new DatagramPacket(datas,0,datas.length);
			//阻塞式接收包裹
			server.receive(packet);
			String str=new String(packet.getData(),0,packet.getLength());
			System.out.println(str);
			if(str.equals("bye")) {
				break;
			}
		}
		//释放资源
		System.out.println("接收完毕");
		server.close();
		
	}

}
