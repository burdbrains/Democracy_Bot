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

        Message messageObj = event.getMessage();

        TextChannel channel = event.getChannel();

        TextChannel demChannel = event.getGuild().getTextChannelsByName("democracy",true).get(0);

        // Using switch/case recommended vvv
        if (messageRaw[0].equalsIgnoreCase("!democracy"))
        {
            if (messageRaw.length == 3)
            {
                User mentionedUser = messageObj.getMentionedUsers().get(0);

                System.out.println(mentionedUser);

                if (messageRaw[1].equalsIgnoreCase("voteban"))
                {
                    if (!mentionedUser.equals(""))
                    {
                        Message message = new MessageBuilder().setContent("Vote to Ban " + mentionedUser.getAsMention()).build();

                        demChannel.sendMessage(message).queue();
                        message.addReaction("U+2705").queue();
                        message.addReaction("U+26D4").queue();
                    }
                }
                else if (messageRaw[1].equalsIgnoreCase("votemute"))
                {
                    if (!mentionedUser.equals(""))
                    {
                        Message message = new MessageBuilder().setContent("Vote to Mute " + mentionedUser.getAsMention()).build();

                        demChannel.sendMessage(message).queue();
                        // https://github.com/DV8FromTheWorld/JDA/wiki/7%29-Using-RestAction
                        // send the message, use the callback and add the reaction.
                        // read above ^^
                        message.addReaction("U+2705").queue();
                        message.addReaction("U+26D4").queue();
                    }
                }
                else if (messageRaw[1].equalsIgnoreCase("votedeaf"))
                {
                    if (!mentionedUser.equals(""))
                    {
                        Message message = new MessageBuilder().setContent("Vote to Deafen " + mentionedUser.getAsMention()).build();

                        demChannel.sendMessage(message).queue();
                        message.addReaction("U+2705").queue();
                        message.addReaction("U+26D4").queue();
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