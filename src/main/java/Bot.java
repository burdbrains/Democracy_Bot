import events.Commands;
import net.dv8tion.jda.api.GatewayEncoding;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import events.Commands.*;


// TODO Make a class for each card game
// TODO Also make a class for all poker games, because games like texas holdem have the same card hand hierarchy and games like blackjack are individual in how cards are scored


public class Bot extends ListenerAdapter
{
    public static void main(String args[]) throws LoginException
    {
        String token = "token";

        JDA jda = JDABuilder.createDefault(token).addEventListeners(new Commands()).build();

        // jda.addEventListener(new Commands());
    }
}