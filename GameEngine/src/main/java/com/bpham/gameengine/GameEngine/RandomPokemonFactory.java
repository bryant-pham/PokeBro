package com.bpham.gameengine.GameEngine;

import com.bpham.gameengine.Model.Monster;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

/**
 * Created by Bryant on 9/21/2014.
 */
public class RandomPokemonFactory implements RandomMonsterFactory {
    //private static final Hashtable<String, Integer> pokemonTable = new Hashtable();
    private static final List<String> pokemonList = new ArrayList<String>();
    private Random randomNumberGenerator;

    static {
        pokemonList.add("bulbasaur");
        pokemonList.add("ivysaur");
        pokemonList.add("venusaur");
        pokemonList.add("charmander");
        pokemonList.add("charmeleon");
        pokemonList.add("charizard");
        pokemonList.add("squirtle");
        pokemonList.add("wartortle");
        pokemonList.add("blastoise");
        pokemonList.add("caterpie");
        pokemonList.add("metapod");
        pokemonList.add("butterfree");
        pokemonList.add("weedle");
        pokemonList.add("kakuna");
        pokemonList.add("beedrill");
        pokemonList.add("pidgey");
        pokemonList.add("pidgeotto");
        pokemonList.add("pidgeot");
        pokemonList.add("rattata");
        pokemonList.add("raticate");
        pokemonList.add("spearow");
        pokemonList.add("fearow");
        pokemonList.add("ekans");
        pokemonList.add("arbok");
        pokemonList.add("pikachu");
        pokemonList.add("raichu");
        pokemonList.add("sandshrew");
        pokemonList.add("sandslash");
        pokemonList.add("nidoran-f");
        pokemonList.add("nidorina");
        pokemonList.add("nidoqueen");
        pokemonList.add("nidoran-m");
        pokemonList.add("nidorino");
        pokemonList.add("nidoking");
        pokemonList.add("clefairy");
        pokemonList.add("clefable");
        pokemonList.add("vulpix");
        pokemonList.add("ninetales");
        pokemonList.add("jigglypuff");
        pokemonList.add("wigglytuff");
        pokemonList.add("zubat");
        pokemonList.add("golbat");
        pokemonList.add("oddish");
        pokemonList.add("gloom");
        pokemonList.add("vileplume");
        pokemonList.add("paras");
        pokemonList.add("parasect");
        pokemonList.add("venonat");
        pokemonList.add("venomoth");
        pokemonList.add("diglett");
        pokemonList.add("dugtrio");
        pokemonList.add("meowth");
        pokemonList.add("persian");
        pokemonList.add("psyduck");
        pokemonList.add("golduck");
        pokemonList.add("mankey");
        pokemonList.add("primeape");
        pokemonList.add("growlithe");
        pokemonList.add("arcanine");
        pokemonList.add("poliwag");
        pokemonList.add("poliwhirl");
        pokemonList.add("poliwrath");
        pokemonList.add("abra");
        pokemonList.add("kadabra");
        pokemonList.add("alakazam");
        pokemonList.add("machop");
        pokemonList.add("machoke");
        pokemonList.add("machamp");
        pokemonList.add("bellsprout");
        pokemonList.add("weepinbell");
        pokemonList.add("victreebel");
        pokemonList.add("tentacool");
        pokemonList.add("tentacruel");
        pokemonList.add("geodude");
        pokemonList.add("graveler");
        pokemonList.add("golem");
        pokemonList.add("ponyta");
        pokemonList.add("rapidash");
        pokemonList.add("slowpoke");
        pokemonList.add("slowbro");
        pokemonList.add("magnemite");
        pokemonList.add("magneton");
        pokemonList.add("farfetchd");
        pokemonList.add("doduo");
        pokemonList.add("dodrio");
        pokemonList.add("seel");
        pokemonList.add("dewgong");
        pokemonList.add("grimer");
        pokemonList.add("muk");
        pokemonList.add("shellder");
        pokemonList.add("cloyster");
        pokemonList.add("gastly");
        pokemonList.add("haunter");
        pokemonList.add("gengar");
        pokemonList.add("onix");
        pokemonList.add("drowzee");
        pokemonList.add("hypno");
        pokemonList.add("krabby");
        pokemonList.add("kingler");
        pokemonList.add("voltorb");
        pokemonList.add("electrode");
        pokemonList.add("exeggcute");
        pokemonList.add("exeggutor");
        pokemonList.add("cubone");
        pokemonList.add("marowak");
        pokemonList.add("hitmonlee");
        pokemonList.add("hitmonchan");
        pokemonList.add("lickitung");
        pokemonList.add("koffing");
        pokemonList.add("weezing");
        pokemonList.add("rhyhorn");
        pokemonList.add("rhydon");
        pokemonList.add("chansey");
        pokemonList.add("tangela");
        pokemonList.add("kangaskhan");
        pokemonList.add("horsea");
        pokemonList.add("seadra");
        pokemonList.add("goldeen");
        pokemonList.add("seaking");
        pokemonList.add("staryu");
        pokemonList.add("starmie");
        pokemonList.add("mr-mime");
        pokemonList.add("scyther");
        pokemonList.add("jynx");
        pokemonList.add("electabuzz");
        pokemonList.add("magmar");
        pokemonList.add("pinsir");
        pokemonList.add("tauros");
        pokemonList.add("magikarp");
        pokemonList.add("gyarados");
        pokemonList.add("lapras");
        pokemonList.add("ditto");
        pokemonList.add("eevee");
        pokemonList.add("vaporeon");
        pokemonList.add("jolteon");
        pokemonList.add("flareon");
        pokemonList.add("porygon");
        pokemonList.add("omanyte");
        pokemonList.add("omastar");
        pokemonList.add("kabuto");
        pokemonList.add("kabutops");
        pokemonList.add("aerodactyl");
        pokemonList.add("snorlax");
        pokemonList.add("articuno");
        pokemonList.add("zapdos");
        pokemonList.add("moltres");
        pokemonList.add("dratini");
        pokemonList.add("dragonair");
        pokemonList.add("dragonite");
        pokemonList.add("mewtwo");
        pokemonList.add("mew");

    }

    //private static final ArrayList<String> pokemonNames = Collections.list(pokemonTable.keys());

    public RandomPokemonFactory(Random randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    private int generateRandomNumber() {
        int minCounterValue = 0;
        int maxCounterValue = pokemonList.size() - 1;
        return randomNumberGenerator.nextInt((maxCounterValue - minCounterValue) + 1) + minCounterValue;
    }

    @Override
    public Monster createRandomMonster() {
        String pokemonName = pokemonList.get(generateRandomNumber());
        //int drawableResource = pokemonTable.get(pokemonName);

        Monster pokemon = new Monster(pokemonName);

        return pokemon;
    }
}
