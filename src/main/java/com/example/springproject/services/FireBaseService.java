package com.example.springproject.services;

import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;

@Service
public class FireBaseService {
    private Storage store = StorageOptions.getDefaultInstance().getService();

    public String save(MultipartFile multipartFile) throws Exception{
        String imageName = String.valueOf(System.currentTimeMillis());
        BlobId blobId = BlobId.of("springproject-fbd13.appspot.com", imageName);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId)
                .setContentType(multipartFile.getContentType())
                .build();
        store = StorageOptions.newBuilder()
                .setCredentials(ServiceAccountCredentials.fromStream(new FileInputStream("springproject-fbd13-firebase-adminsdk-3b4ja-9027fac4c8.json")))
                .build()
                .getService();
        store.create(blobInfo, multipartFile.getInputStream());
        return imageName;
    }

    public String getUrl(String filename){
        return "https://firebasestorage.googleapis.com/v0/b/springproject-fbd13.appspot.com/o/"+filename+"?alt=media&token=35a5c81e-60a6-4239-ad1a-ef88e50c879b";
    }
}
