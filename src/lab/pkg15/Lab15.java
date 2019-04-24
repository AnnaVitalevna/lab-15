package lab.pkg15;

public class Lab15{

    private static String srcFile;
    private static String dstFile;
    private static int bufSize;

    public static void main(String[] args) {
	    for(String str: args){
	        String[] key_val = str.split("=");

	        if(key_val[0].compareTo("--srcfile") == 0)
	            srcFile = key_val[1];

                if(key_val[0].compareTo("--dstfile") == 0)
                    dstFile = key_val[1];

                if(key_val[0].compareTo("--buffer") == 0)
                    bufSize = Integer.parseInt(key_val[1]);

        }

        CopyFile fm = new CopyFile();

        double time = fm.copy(srcFile, dstFile, bufSize);
        System.out.println("File copy time: " + time + " second");


   }
}
