package br.com.invitedlist.repository;

import br.com.invitedlist.model.Invited;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InvitedRepository extends CrudRepository<Invited, Long> {

	List<Invited> findByName(String name);

}
