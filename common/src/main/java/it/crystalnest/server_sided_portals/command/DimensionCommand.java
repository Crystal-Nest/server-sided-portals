package it.crystalnest.server_sided_portals.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import it.crystalnest.server_sided_portals.Constants;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.DimensionArgument;
import net.minecraft.commands.arguments.TimeArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;

public class DimensionCommand {
  public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
    dispatcher.register(
      Commands.literal("dimension").requires(stack -> stack.hasPermission(2)).then(
        Commands.argument("dimension", DimensionArgument.dimension()).then(
          Commands.literal("time").then(
            Commands.literal("set").then(
              Commands.literal("day").executes(context -> setTime(context.getSource(), DimensionArgument.getDimension(context, "dimension"), 1000))
            ).then(
              Commands.literal("noon").executes(context -> setTime(context.getSource(), DimensionArgument.getDimension(context, "dimension"), 6000))
            ).then(
              Commands.literal("night").executes(context -> setTime(context.getSource(), DimensionArgument.getDimension(context, "dimension"), 13000))
            ).then(
              Commands.literal("midnight").executes(context -> setTime(context.getSource(), DimensionArgument.getDimension(context, "dimension"), 18000))
            ).then(
              Commands.argument("time", TimeArgument.time()).executes(context -> setTime(context.getSource(), DimensionArgument.getDimension(context, "dimension"), IntegerArgumentType.getInteger(context, "time")))
            )
          ).then(
            Commands.literal("add").then(
              Commands.argument("time", TimeArgument.time()).executes(context -> addTime(context.getSource(), DimensionArgument.getDimension(context, "dimension"), IntegerArgumentType.getInteger(context, "time")))
            )
          ).then(
            Commands.literal("query").then(
              Commands.literal("daytime").executes(context -> queryTime(context.getSource(), getDayTime(DimensionArgument.getDimension(context, "dimension"))))
            ).then(
              Commands.literal("gametime").executes(context -> queryTime(context.getSource(), (int) (DimensionArgument.getDimension(context, "dimension").getGameTime() % 2147483647L)))
            ).then(
              Commands.literal("day").executes(context -> queryTime(context.getSource(), (int) (DimensionArgument.getDimension(context, "dimension").getDayTime() / 24000L % 2147483647L)))
            )
          )
        )
      )
    );
  }

  private static int getDayTime(ServerLevel pLevel) {
    return (int) (pLevel.getDayTime() % 24000L);
  }

  private static int queryTime(CommandSourceStack stack, int time) {
    stack.sendSuccess(() -> Component.translatable("commands.time.query", time), false);
    return time;
  }

  public static int setTime(CommandSourceStack stack, ServerLevel dimension, int time) {
    for (ServerLevel serverlevel : stack.getServer().getAllLevels()) {
      serverlevel.setDayTime(time);
      if (serverlevel == dimension) {
        Constants.LOGGER.error("Y - {} - {}", dimension, ((Test) dimension).getLevelData().getClass().getSimpleName());
      } else {
        Constants.LOGGER.error("N - {} - {}", dimension, ((Test) dimension).getLevelData().getClass().getSimpleName());
      }
    }
//    dimension.setDayTime(time);
    stack.sendSuccess(() -> Component.translatable("commands.time.set", time), true);
    return getDayTime(dimension);
  }

  public static int addTime(CommandSourceStack stack, ServerLevel dimension, int amount) {
    dimension.setDayTime(dimension.getDayTime() + amount);
    int i = getDayTime(dimension);
    stack.sendSuccess(() -> Component.translatable("commands.time.set", i), true);
    return i;
  }
}
