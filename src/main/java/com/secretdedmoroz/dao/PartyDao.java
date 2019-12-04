package com.secretdedmoroz.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.secretdedmoroz.model.Party;

@Repository
public class PartyDao {

    private static List<Party> parties = new ArrayList<>();

    public static List<Party> getParties() {
        return parties;
    }

    public static void setParties(final List<Party> parties) {
        PartyDao.parties = parties;
    }

    public boolean addParty(Party party) {
        if (!parties.contains(party)) {
            return parties.add(party);
        } else {
            return false;
        }
    }

    public Party getPartyByUrl(final String partyUrl) {
        return parties.stream().filter(r -> r.getUrl().equals(partyUrl)).findFirst().orElse(null);
    }
}
