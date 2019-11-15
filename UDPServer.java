package UDP;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * ���ն�
 * 1��ʹ��DatagramSocket ָ���˿ڣ��������նˡ�
 * 2��׼����������װ��DatagramPacket����
 * 3������ʽ���հ���
 * 4����������
 * 5���ͷ���Դ
 * 
 * @author dell
 *
 */

public class UDPServer {
	public static void main(String[] args) throws Exception {
		System.out.println("���շ�������....");
		//ʹ��DatagramSocket ָ���˿ڣ��������ն�
		DatagramSocket server=new DatagramSocket(6666);
		
		//��������
		/*ByteArrayInputStream is=new ByteArrayInputStream(packet.getData());
		OutputStream os=new BufferedOutputStream(new FileOutputStream(new File("copy.jpg")));
		byte[] flush=new byte[1024];
		while(is.read(flush)!=-1) {
			os.write(flush);
		}
		os.flush();*/
		while(true) {
			//׼����������װ��DatagramPacket����
			byte[] datas=new byte[1024*60];
			DatagramPacket packet=new DatagramPacket(datas,0,datas.length);
			//����ʽ���հ���
			server.receive(packet);
			String str=new String(packet.getData(),0,packet.getLength());
			System.out.println(str);
			if(str.equals("bye")) {
				break;
			}
		}
		//�ͷ���Դ
		System.out.println("�������");
		server.close();
		
	}

}
