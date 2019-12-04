package com.secretdedmoroz.service;

import java.util.Set;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.secretdedmoroz.dao.PartyDao;
import com.secretdedmoroz.dao.UserDao;
import com.secretdedmoroz.model.Party;
import com.secretdedmoroz.model.User;

@Service
public class PartyService {

    @Resource
    private PartyDao partyDao;
    @Resource
    private UserDao userDao;

    public String createParty(String ownerEmail, final String partyName) {
        String url = "localhost:8080/rooms?roomUrl=" + UUID.randomUUID() + "_" + partyName;
        User owner = userDao.getUserByEmail(ownerEmail);
        Party party = new Party();
        party.setOwner(owner);
        party.setPartyName(partyName);
        setDefaultDuration();
        party.setUrl(url);
        partyDao.addParty(party);
        return url;
    }

    public Party getPartyByUrl(String partyUrl) {
        return partyDao.getPartyByUrl(partyUrl);
    }

    private void setDefaultDuration() {

    }

    public void addPlayersToParty(final String partyByUrl, final Set<User> users) {
        Party party = partyDao.getPartyByUrl(partyByUrl);
        party.getPlayers().addAll(users);
    }
}
