package com.msb.dongbao.portal.web.code;

import lombok.Data;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

/**
 * @author 马士兵教育:chaopengfei
 * @date 2021/2/2
 */
@Data
public class ImageCode {

	// 图形中的内容
	private String code;

	// 图片
	private ByteArrayInputStream image;

	private int width = 400;

	private int height = 100;

	// 课下丰富好单例
	public static ImageCode getInstance() throws IOException {
		return new ImageCode();
	}

	private ImageCode() throws IOException {
		// 图形缓冲区 给个黑板
		BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);

		// 给你支画笔
		Graphics graphics = image.getGraphics();

		// 拿笔 涂色，画图形
		graphics.setColor(new Color(255,255,255));
		// 画矩形
		graphics.fillRect(0,0,width,height);

		// 字体
		graphics.setFont(new Font("宋体",Font.PLAIN,30));

		Random random = new Random();
		this.code = "";
		for (int i=0;i<6;i++){
			String s = String.valueOf(random.nextInt(10));
			this.code += s;

			graphics.setColor(new Color(0,0,0));
			graphics.drawString(s,(width/6)*i,40);

			// 划线
			graphics.setColor(new Color(100,100,100));
			graphics.drawLine((width/6)*i,40,(width/6)*i+25,40-30);
		}

//		// 识别中文测试
//		graphics.setColor(new Color(0,0,0));
//		graphics.drawString("我是中国人",(width/6),40);

		graphics.setColor(new Color(100,100,100));
		for (int i=0;i<100;i++){
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int x1 = random.nextInt(20);
			int y1 = random.nextInt(20);
			graphics.drawLine(x,y,x+x1,y+y1);

		}




		// 收笔
		graphics.dispose();

		ByteArrayInputStream inputStream = null;
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

		try {
			// 赋值给byteArrayInputStream
			ImageOutputStream imageOutputStream = ImageIO.createImageOutputStream(outputStream);
			ImageIO.write(image,"jpeg",imageOutputStream);

			inputStream = new ByteArrayInputStream(outputStream.toByteArray());

		}catch (Exception e){
			System.out.println("生成验证码失败");
		}

		this.image = inputStream;


	}

}
