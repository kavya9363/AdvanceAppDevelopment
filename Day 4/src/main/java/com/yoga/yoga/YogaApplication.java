package com.yoga.yoga;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.boot.context.event.ApplicationReadyEvent;
// import org.springframework.context.event.EventListener;

// import com.yoga.yoga.service.impl.EmailSenderService;

// import jakarta.mail.MessagingException;

@SpringBootApplication
public class YogaApplication {

	// @Autowired
	// private EmailSenderService senderService;

	public static void main(String[] args) {
		SpringApplication.run(YogaApplication.class, args);  
		System.out.println("success");
	}

	// @EventListener(ApplicationReadyEvent.class)
	// public void triggerMail() throws MessagingException {
	// 	senderService.sendSimpleEmail("727821tucs133@skct.edu.in",
	// 			"Greetings!!",
	// 			"Dear user, Welcome to our yoga community! We're thrilled to have you.");

	// }
}
