package events;

import net.dv8tion.jda.api.MessageBuilder;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.guild.react.GenericGuildMessageReactionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import java.util.regex.Matcher;


public class Commands extends ListenerAdapter
{

    @Override
    public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent event) {
        super.onGuildMessageReceived(event);
        String[] messageRaw = event.getMessage().getContentRaw().split(" ");

        TextChannel channel = event.getChannel();

        TextChannel demChannel = event.getGuild().getTextChannelsByName("democracy",true).get(0);

        // Using switch/case recommended vvv
        if (messageRaw[0].equalsIgnoreCase("!democracy"))
        {
            if (messageRaw.length == 3)
            {
                if (messageRaw[1].equalsIgnoreCase("voteban"))
                {
                    User inputUser = User.fromId(messageRaw[3]);
                    if (!inputUser.equals(null))
                    {
                        Message message = new MessageBuilder().setContent("Vote to Ban " + inputUser.getAsMention()).build();

                        channel.sendMessage(message).queue();
                        message.addReaction("U+2705");
                        message.addReaction("U+26D4");
                    }
                }
                else if (messageRaw[1].equalsIgnoreCase("votemute"))
                {
                    User inputUser = User.fromId(messageRaw[3]);
                    if (!inputUser.equals(null))
                    {
                        Message message = new MessageBuilder().setContent("Vote to Mute " + inputUser.getAsMention()).build();

                        channel.sendMessage(message).queue();
                        message.addReaction("U+2705");
                        message.addReaction("U+26D4");
                    }
                }
                else if (messageRaw[1].equalsIgnoreCase("votedeaf"))
                {
                    User inputUser = User.fromId(messageRaw[3]);
                    if (!inputUser.equals(null))
                    {
                        Message message = new MessageBuilder().setContent("Vote to Deafen " + inputUser.getAsMention()).build();

                        channel.sendMessage(message).queue();
                        message.addReaction("U+2705");
                        message.addReaction("U+26D4");
                    }
                }
                else
                {
                    channel.sendMessage("!!! To properly use this command !democracy [voteban, votemute, votedeaf] [@user] !!!").queue();
                }
            }
            else
            {
                channel.sendMessage("!!! To properly use this command !democracy [voteban, votemute, votedeaf] [@user] !!!").queue();
            }
        }
    }

    @Override
    public void onGenericGuildMessageReaction(@Nonnull GenericGuildMessageReactionEvent event)
    {
        super.onGenericGuildMessageReaction(event);
        // Handle action when democracy message recieves enough reactions.

        event.getMessageId();

        TextChannel channel = event.getChannel();

        TextChannel demChannel = event.getGuild().getTextChannelsByName("democracy",true).get(0);

        if (channel.equals(demChannel))
        {
        }
    }
}