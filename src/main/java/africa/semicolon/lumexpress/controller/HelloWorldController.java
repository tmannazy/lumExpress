package africa.semicolon.lumexpress.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloWorldController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello World!!!";
    }

    @DeleteMapping("deleteHello")
    public void deleteFile() {
        System.out.println("File deleted");
    }

}
