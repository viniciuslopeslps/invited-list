package br.com.invitedlist.service;

import br.com.invitedlist.model.Invited;
import br.com.invitedlist.repository.InvitedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvitedService {

    @Autowired
    private InvitedRepository repository;

    public Iterable<Invited> findAll() {
        return repository.findAll();
    }


    public Invited save(Invited invited) {
        return repository.save(invited);
    }

}
