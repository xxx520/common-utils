package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;


public class Main {
	public static void main(String[] args) {
	//http://hq.sinajs.cn/list=sh601006	
		try {
			while (true) {
				System.out.println(new Date());
//				getStockInfoByCode("sh601006");
//				getStockInfoByCode("sh600122");
//				getStockInfoByCode("sh600891");
////				getStockInfoByCode("sh600723");
////				getStockInfoByCode("sz300658");
//				getStockInfoByCode("sz300110");
				getStockInfoByCode("sz002029");
				getStockInfoByCode("sh603728");
				getStockInfoByCode("sz002459");
				Thread.sleep(10*1000);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 private static final int COLUMNS = 32;  
	public static String[]  getStockInfoByCode(String stockCode) throws IOException{  
        // 仅仅打印  
         URL url = new URL("http://hq.sinajs.cn/?list="+stockCode) ;  
         URLConnection connection = url.openConnection() ;  
         connection.setConnectTimeout(16000) ;  
         BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream())) ;  
         String line = null ;  
         StringBuffer sb = new StringBuffer() ;  
         while(( line = br.readLine()) != null ){  
             sb.append(line) ;  
         }
//         System.out.println(sb.toString());
         
         String[] ss=sb.toString().split( ",");
         StringBuffer info=new StringBuffer();
         info.append( ss[1]+"(开)"+ss[2]+"(收)"+ss[3]+"(C)"+ss[4]+"(max)"+ss[5]+"(min)");
//         for(int i=0;i<5;i++){
//        	 info.append(ss[i+1]+" ");
//         }
         StringBuffer bs=new StringBuffer();
         for(int i=10;i<20;i++){
        	 if(i%2!=0){
        		 continue;
        	 }
        	 bs.append(ss[i+1]+":"+ss[i]+" ");
         }
         StringBuffer sas=new StringBuffer();
         for(int i=20;i<30;i++){
        	 if(i%2!=0){
        		 continue;
        	 }
        	 sas.append(ss[i+1]+":"+ss[i]+" ");
         }
         System.out.println(info);
         System.out.println(bs);
         System.out.println(sas);
         return null;
    }  
}
