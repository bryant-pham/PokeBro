package com.pokebro.GameEngine;

import com.pokebro.Model.Monster;
import com.pokebro.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Random;

/**
 * Created by Bryant on 9/21/2014.
 */
public class RandomPokemonFactory implements RandomMonsterFactory {
    private static final Hashtable<String, Integer> pokemonTable = new Hashtable();
    private Random randomNumberGenerator;

    static {
        pokemonTable.put("bulbasaur", R.drawable.bulbasaur);
        pokemonTable.put("ivysaur", R.drawable.ivysaur);
        pokemonTable.put("venusaur", R.drawable.venusaur);
        pokemonTable.put("charmander", R.drawable.charmander);
        pokemonTable.put("charmeleon", R.drawable.charmeleon);
        pokemonTable.put("charizard", R.drawable.charizard);
        pokemonTable.put("squirtle", R.drawable.squirtle);
        pokemonTable.put("wartortle", R.drawable.wartortle);
        pokemonTable.put("blastoise", R.drawable.blastoise);
        pokemonTable.put("caterpie", R.drawable.caterpie);
        pokemonTable.put("metapod", R.drawable.metapod);
        pokemonTable.put("butterfree", R.drawable.butterfree);
        pokemonTable.put("weedle", R.drawable.weedle);
        pokemonTable.put("kakuna", R.drawable.kakuna);
        pokemonTable.put("beedrill", R.drawable.beedrill);
        pokemonTable.put("pidgey", R.drawable.pidgey);
        pokemonTable.put("pidgeotto", R.drawable.pidgeotto);
        pokemonTable.put("pidgeot", R.drawable.pidgeot);
        pokemonTable.put("rattata", R.drawable.rattata);
        pokemonTable.put("raticate", R.drawable.raticate);
        pokemonTable.put("spearow", R.drawable.spearow);
        pokemonTable.put("fearow", R.drawable.fearow);
        pokemonTable.put("ekans", R.drawable.ekans);
        pokemonTable.put("arbok", R.drawable.arbok);
        pokemonTable.put("pikachu", R.drawable.pikachu);
        pokemonTable.put("raichu", R.drawable.raichu);
        pokemonTable.put("sandshrew", R.drawable.sandshrew);
        pokemonTable.put("sandslash", R.drawable.sandslash);
        pokemonTable.put("nidoran-f", R.drawable.nidoran_f);
        pokemonTable.put("nidorina", R.drawable.nidorina);
        pokemonTable.put("nidoqueen", R.drawable.nidoqueen);
        pokemonTable.put("nidoran-m", R.drawable.nidoran_m);
        pokemonTable.put("nidorino", R.drawable.nidorino);
        pokemonTable.put("nidoking", R.drawable.nidoking);
        pokemonTable.put("clefairy", R.drawable.clefairy);
        pokemonTable.put("clefable", R.drawable.clefable);
        pokemonTable.put("vulpix", R.drawable.vulpix);
        pokemonTable.put("ninetales", R.drawable.ninetales);
        pokemonTable.put("jigglypuff", R.drawable.jigglypuff);
        pokemonTable.put("wigglytuff", R.drawable.wigglytuff);
        pokemonTable.put("zubat", R.drawable.zubat);
        pokemonTable.put("golbat", R.drawable.golbat);
        pokemonTable.put("oddish", R.drawable.oddish);
        pokemonTable.put("gloom", R.drawable.gloom);
        pokemonTable.put("vileplume", R.drawable.vileplume);
        pokemonTable.put("paras", R.drawable.paras);
        pokemonTable.put("parasect", R.drawable.parasect);
        pokemonTable.put("venonat", R.drawable.venonat);
        pokemonTable.put("venomoth", R.drawable.venomoth);
        pokemonTable.put("diglett", R.drawable.diglett);
        pokemonTable.put("dugtrio", R.drawable.dugtrio);
        pokemonTable.put("meowth", R.drawable.meowth);
        pokemonTable.put("persian", R.drawable.persian);
        pokemonTable.put("psyduck", R.drawable.psyduck);
        pokemonTable.put("golduck", R.drawable.golduck);
        pokemonTable.put("mankey", R.drawable.mankey);
        pokemonTable.put("primeape", R.drawable.primeape);
        pokemonTable.put("growlithe", R.drawable.growlithe);
        pokemonTable.put("arcanine", R.drawable.arcanine);
        pokemonTable.put("poliwag", R.drawable.poliwag);
        pokemonTable.put("poliwhirl", R.drawable.poliwhirl);
        pokemonTable.put("poliwrath", R.drawable.poliwrath);
        pokemonTable.put("abra", R.drawable.abra);
        pokemonTable.put("kadabra", R.drawable.kadabra);
        pokemonTable.put("alakazam", R.drawable.alakazam);
        pokemonTable.put("machop", R.drawable.machop);
        pokemonTable.put("machoke", R.drawable.machoke);
        pokemonTable.put("machamp", R.drawable.machamp);
        pokemonTable.put("bellsprout", R.drawable.bellsprout);
        pokemonTable.put("weepinbell", R.drawable.weepinbell);
        pokemonTable.put("victreebel", R.drawable.victreebel);
        pokemonTable.put("tentacool", R.drawable.tentacool);
        pokemonTable.put("tentacruel", R.drawable.tentacruel);
        pokemonTable.put("geodude", R.drawable.geodude);
        pokemonTable.put("graveler", R.drawable.graveler);
        pokemonTable.put("golem", R.drawable.golem);
        pokemonTable.put("ponyta", R.drawable.ponyta);
        pokemonTable.put("rapidash", R.drawable.rapidash);
        pokemonTable.put("slowpoke", R.drawable.slowpoke);
        pokemonTable.put("slowbro", R.drawable.slowbro);
        pokemonTable.put("magnemite", R.drawable.magnemite);
        pokemonTable.put("magneton", R.drawable.magneton);
        pokemonTable.put("farfetchd", R.drawable.farfetchd);
        pokemonTable.put("doduo", R.drawable.doduo);
        pokemonTable.put("dodrio", R.drawable.dodrio);
        pokemonTable.put("seel", R.drawable.seel);
        pokemonTable.put("dewgong", R.drawable.dewgong);
        pokemonTable.put("grimer", R.drawable.grimer);
        pokemonTable.put("muk", R.drawable.muk);
        pokemonTable.put("shellder", R.drawable.shellder);
        pokemonTable.put("cloyster", R.drawable.cloyster);
        pokemonTable.put("gastly", R.drawable.gastly);
        pokemonTable.put("haunter", R.drawable.haunter);
        pokemonTable.put("gengar", R.drawable.gengar);
        pokemonTable.put("onix", R.drawable.onix);
        pokemonTable.put("drowzee", R.drawable.drowzee);
        pokemonTable.put("hypno", R.drawable.hypno);
        pokemonTable.put("krabby", R.drawable.krabby);
        pokemonTable.put("kingler", R.drawable.kingler);
        pokemonTable.put("voltorb", R.drawable.voltorb);
        pokemonTable.put("electrode", R.drawable.electrode);
        pokemonTable.put("exeggcute", R.drawable.exeggcute);
        pokemonTable.put("exeggutor", R.drawable.exeggutor);
        pokemonTable.put("cubone", R.drawable.cubone);
        pokemonTable.put("marowak", R.drawable.marowak);
        pokemonTable.put("hitmonlee", R.drawable.hitmonlee);
        pokemonTable.put("hitmonchan", R.drawable.hitmonchan);
        pokemonTable.put("lickitung", R.drawable.lickitung);
        pokemonTable.put("koffing", R.drawable.koffing);
        pokemonTable.put("weezing", R.drawable.weezing);
        pokemonTable.put("rhyhorn", R.drawable.rhyhorn);
        pokemonTable.put("rhydon", R.drawable.rhydon);
        pokemonTable.put("chansey", R.drawable.chansey);
        pokemonTable.put("tangela", R.drawable.tangela);
        pokemonTable.put("kangaskhan", R.drawable.kangaskhan);
        pokemonTable.put("horsea", R.drawable.horsea);
        pokemonTable.put("seadra", R.drawable.seadra);
        pokemonTable.put("goldeen", R.drawable.goldeen);
        pokemonTable.put("seaking", R.drawable.seaking);
        pokemonTable.put("staryu", R.drawable.staryu);
        pokemonTable.put("starmie", R.drawable.starmie);
        pokemonTable.put("mr-mime", R.drawable.mr_mime);
        pokemonTable.put("scyther", R.drawable.scyther);
        pokemonTable.put("jynx", R.drawable.jynx);
        pokemonTable.put("electabuzz", R.drawable.electabuzz);
        pokemonTable.put("magmar", R.drawable.magmar);
        pokemonTable.put("pinsir", R.drawable.pinsir);
        pokemonTable.put("tauros", R.drawable.tauros);
        pokemonTable.put("magikarp", R.drawable.magikarp);
        pokemonTable.put("gyarados", R.drawable.gyarados);
        pokemonTable.put("lapras", R.drawable.lapras);
        pokemonTable.put("ditto", R.drawable.ditto);
        pokemonTable.put("eevee", R.drawable.eevee);
        pokemonTable.put("vaporeon", R.drawable.vaporeon);
        pokemonTable.put("jolteon", R.drawable.jolteon);
        pokemonTable.put("flareon", R.drawable.flareon);
        pokemonTable.put("porygon", R.drawable.porygon);
        pokemonTable.put("omanyte", R.drawable.omanyte);
        pokemonTable.put("omastar", R.drawable.omastar);
        pokemonTable.put("kabuto", R.drawable.kabuto);
        pokemonTable.put("kabutops", R.drawable.kabutops);
        pokemonTable.put("aerodactyl", R.drawable.aerodactyl);
        pokemonTable.put("snorlax", R.drawable.snorlax);
        pokemonTable.put("articuno", R.drawable.articuno);
        pokemonTable.put("zapdos", R.drawable.zapdos);
        pokemonTable.put("moltres", R.drawable.moltres);
        pokemonTable.put("dratini", R.drawable.dratini);
        pokemonTable.put("dragonair", R.drawable.dragonair);
        pokemonTable.put("dragonite", R.drawable.dragonite);
        pokemonTable.put("mewtwo", R.drawable.mewtwo);
        pokemonTable.put("mew", R.drawable.mew);

    }

    private static final ArrayList<String> pokemonNames = Collections.list(pokemonTable.keys());

    public RandomPokemonFactory(Random randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    private int generateRandomNumber() {
        int minCounterValue = 0;
        int maxCounterValue = pokemonNames.size() - 1;
        return randomNumberGenerator.nextInt((maxCounterValue - minCounterValue) + 1) + minCounterValue;
    }

    @Override
    public Monster createRandomMonster() {
        String pokemonName = pokemonNames.get(generateRandomNumber());
        int drawableResource = pokemonTable.get(pokemonName);

        Monster pokemon = new Monster(pokemonName, drawableResource);

        return pokemon;
    }
}
