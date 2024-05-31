package group.bootcamp.technicaltest.service;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {EmailService.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class EmailServiceDiffblueTest {
    @Autowired
    private EmailService emailService;

    @MockBean
    private JavaMailSender javaMailSender;

    /**
     * Method under test:
     * {@link EmailService#sendSimpleMessage(String, String, String)}
     */
    @Test
    void testSendSimpleMessage() throws MailException {
        // Arrange
        doNothing().when(javaMailSender).send(Mockito.<SimpleMailMessage>any());

        // Act
        emailService.sendSimpleMessage("alice.liddell@example.org", "Hello from the Dreaming Spires", "Text");

        // Assert
        verify(javaMailSender).send(isA(SimpleMailMessage.class));
    }
    //mockito : prilaku yang benar
    //classical : hasil ynag benar
}
