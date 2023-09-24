package belajar.springboot._04Rest.restspring.util.logging;


import org.springframework.stereotype.Component;


public class FileNameExtractor {
    public String extractFileName(String filePath){
        int lastIndexOfSlash = filePath.lastIndexOf("\\");
        if (lastIndexOfSlash >= 0) {
            return filePath.substring(lastIndexOfSlash + 1);
        } else {
            // Jika tidak ada slash dalam path, kembalikan path utuh sebagai nama file
            return filePath;
        }
    }
}
