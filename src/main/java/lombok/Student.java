package lombok;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @ToString
@Slf4j
public class Student {

    private Long id;
    private String firstName;
    private String lastName;

    public void logInfo(){
        log.info("Student id: {}, name: {}{}", id, firstName, lastName);
    }



}
