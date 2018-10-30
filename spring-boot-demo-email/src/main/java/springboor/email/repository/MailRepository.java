package springboor.email.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springboor.email.entity.OaEmail;

public interface MailRepository extends JpaRepository<OaEmail,Integer> {

}
