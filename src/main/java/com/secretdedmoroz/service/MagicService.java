package com.secretdedmoroz.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.secretdedmoroz.dao.PartyDao;
import com.secretdedmoroz.model.Party;
import com.secretdedmoroz.model.User;

@Service
public class MagicService {

    @Resource
    private PartyDao partyDao;

    public Map<User, User> doMagic(String partyUrl) {
        Party party = partyDao.getPartyByUrl(partyUrl);
        Set<User> players = party.getPlayers();
        return doRandomPares(new ArrayList<>(players));
    }

    private Map<User, User> doRandomPares(final List<User> senders) {
        Random random = new Random();
        Map<User, User> pares = new HashMap<>();
        List<User> receivers = new ArrayList<>(senders);
        int size = senders.size();

        for (int i = 0; i < size; i++) {
            User sender = senders.get(i);
            User receiver = getRandomReceiver(random, receivers);
            if (!sender.equals(receiver)) {
                pares.put(sender, receiver);
                receivers.remove(receiver);
            } else {
                --i;
                continue;
            }
        }

        if (!checkPares(pares)) {
            doRandomPares(senders);
        }

        return pares;
    }

    private boolean checkPares(final Map<User, User> pares) {
        return pares.keySet().stream().filter(k -> k.equals(pares.get(k))).collect(Collectors.toList()).isEmpty();
    }

    private User getRandomReceiver(final Random random, final List<User> receivers) {
        return receivers.get(random.nextInt(receivers.size()));
    }


}
