package com.example.demo.components;

import com.example.demo.models.File;
import com.example.demo.models.Folder;
import com.example.demo.models.User;
import com.example.demo.repository.FileRepository;
import com.example.demo.repository.FolderRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FileRepository fileRepository;

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    UserRepository userRepository;

    public DataLoader() {
    }

    public void run(ApplicationArguments args) throws Exception {

        User matthew = new User("Matthew");
        userRepository.save(matthew);

        Folder folder = new Folder("folder",matthew);
        folderRepository.save(folder);

        File duck = new File("Ducks",".txt",100,folder);
        fileRepository.save(duck);

    }
}
