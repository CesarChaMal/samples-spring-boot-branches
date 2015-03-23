package samples.springboot.server.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import java.util.Date;

/**
 * Created by izeye on 15. 3. 23..
 */
@Entity
@Data
@EqualsAndHashCode(exclude = "collectedTime")
@ToString(exclude = "server")
public class ServerStatus {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	private Server server;

	private boolean alive;

	private Date collectedTime;

	@PrePersist
	public void onCreate() {
		setCollectedTime(new Date());
	}

}
