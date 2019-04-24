package lab.pkg15;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.*;
import java.util.Date;

class CopyFile {
  double copy (String src, String dst, int bufSize) throws InvalidPathException
    {
        Date startTime = new Date();
        Path srcpath = Paths.get(src);
        Path dstpath = Paths.get(dst);

        long srcFileSize;
        long dstFileSize = 0;

        ByteBuffer buffer = ByteBuffer.allocate(bufSize);

        try(SeekableByteChannel srcChan = Files.newByteChannel(srcpath); SeekableByteChannel dstChan = Files.newByteChannel(dstpath, StandardOpenOption.WRITE, StandardOpenOption.CREATE)){
            srcFileSize = Files.size(srcpath);
            int currBufSize;

            do {
                currBufSize = srcChan.read(buffer);
                buffer.rewind();
                dstChan.write(buffer);
                dstFileSize += buffer.position();
                buffer.rewind();

                System.out.println("File copy progress: " + ((double)dstFileSize / (double)srcFileSize)*100+" %");
            }
            while (currBufSize > 0);

        }
        catch (IOException e)
        {
        }
        
        Date endTime = new Date();
        return (double)(endTime.getTime() - startTime.getTime())/1000;
    }
}