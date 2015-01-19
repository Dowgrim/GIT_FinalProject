package zuul.languages;

import java.util.ListResourceBundle;

import zuul.commands.CommandWord;

/**
 * This class contains all the traductions of the game in english
	@author Nicolas HORY and Cindy NAJJAR
*/

public class Zuul_en_US extends ListResourceBundle {
	static final Object[][] contents = {
			{"game.welcome", "Welcome to the World of Zuul !"},
			{"game.desc", "World of Zuul is a new, incredibly boring adventure game."},
			{"game.help", "Type '" + CommandWord.HELP + "' if you need help."},
			{"game.unknown", "I don't know what you mean..."},
			{"game.lunch", "You are not in the lunchroom, you can't play !"},
			{"help.first", "You are lost. You are alone."},
			{"help.second", "You wander around at the university."},
			{"help.third", "Your command words are:"},
			{"light.prob", "You can't change light in the "},
			{"desc.cor1", "corridor 1 with lecture and lab rooms"},
			{"desc.cor2", "corridor 2 with exam room and places to spend your time"},
			{"desc.lab", "lab room, get ready for a session !"},
			{"desc.amphi1", "first ampitheater"},
			{"desc.amphi2", "second amphitheater"},
			{"desc.exam", "exam room"},
			{"desc.lunch", "lunchroom"},
			{"desc.lib", "library"},
			
			{"game.end", "Thank you for playing.  Good bye."},
			{"go.error", "Go where?"},
			{"go.door", "There is no door !"},
			{"play.no", "\nThere is nobody to play babyfoot, but you can train yourself if you want by taping \"play\" !"},
			{"play.yes", "\nYour two best friends are here, it's time for a round of babyfoot !"},
			{"pick.error", "Pick up what ?"},
			{"pick.done", "You've just picked up all the items of the room !"},
			{"list.item", "Your current inventory contains : "},
			{"pick.light", "You can't even see items, how would you pick them up ?"},
			{"lib.error", "The library is currently closed, come back later !"},
			{"desc.room", "You are in the "},
			{"play.baby", "You're playing babyfoot, and will forget one lecture !\n"},
			{"forgot.course", "You've just forgotten the lecture "},
			
			{"light.yes", "The light is now on !"},
			{"light.no", "The light is now off !"},
			{"pick.nothing", "There is not any object to pick up !"},
			{"quit.error", "Quit what ?"},
			{"room.obj", "Objects in this room : "},
			{"obj.error", "Not any object"},
			{"drink.error", "You can't drink coffee outside of the lunchroom !"},
			{"drink.cof", "You drank a coffee. Now you have "},
			{"energy.pts", " energy points !"},
			{"error.cof", "You can't drink a coffee, you don't have any of it !"},
			{"play.tablet", "You just started your tablet !"},
			{"video.game", "The tablet just started a video game.."},
			{"play.zuul", "You just played World of Zuul, which didn't have any impact on your knowledge"},
			{"play.game", "You just played a game not really instructive..."},
			{"no.tablet", "You don't even have a tablet to play !"},
			{"tablet.learn", "Your tablet opens Internet on the university's website with lectures and labs !"},
			
			{"POO.enum", "POO"},
			{"ALGO.enum", "ALGO"},
			{"MATHS.enum", "MATHS"},
			{"POO.course0", "\"If two classes depend closely on many details of each other, we say they are tightly coupled. \n We aim for loose coupling !\"\n"},
			{"POO.course1", "\"If each unit is responsible for one single logical task, we say it has high cohesion.\nWe aim for high cohesion !\"\n"},
			{"POO.course2", "\"Classes should represent one single, well defined entity. \nA method should be responsible for one and only one well defined task.\"\n"},		
			{"POO.lab0", "\"The best way to avoid tightly coupled classes is defining one for each entity of the project.\"\n"},
			{"POO.lab1", "\"A way to get high cohesion is to define all the necessary tasks, and create the methods after.\"\n"},
			{"POO.lab2", "\"When you're programming in Java, you can make an UML diagram to organize your ideas.\"\n"},
			
			{"all.lect", "The lectures you already attended : "},
			{"all.lab", "The labs you already attended : "},
			{"forgot.course", "You just forgot this course : "},
			{"forgot.lab", "You just forgot this lab session : "},
			{"learn.lab", "You just followed the lab session : "},
			{"learn.lect", "You just followed this lecture : "},
			{"know.lect", "You already followed the lecture : "},
			{"unk.lect1", "You can't do the lab session "},
			{"unk.lect2", " without having followed the corresponding lecture !"},
			{"bad.lect", "You can get out, you don't have to follow the lecture of "},
			{"bad.lab", "You can get out, you don't have to follow the lab session of "},
			{"know.lab1", "You already followed the lab session "},
			{"know.lab2", ", you can get out !"},
			{"no.lects", "Not any lecture"},
			{"no.labs", "Not any lab"},
			{"tab.prob", "The lecture you read was not POO, so you don't care about it !"},
			{"lab.present", "The teacher enters the lab for your lab session :"},
			{"lect.present", "The teacher enters the class for your lecture :"},
			{"room.exits", "The available exits of the room : "},
			{"empty.inv", "Your current inventory is empty."},
			{"no.lectures", "You can't forget a lecture because you didn't follow any of it !"},
			{"read.book", "You just read POO book, which made you learn all the POO lectures !"},
			{"book.prob", "You can't read a book, you're not in the library and you didn't borrom it !"},
			{"will.read", "You open the POO book..."},
			{"book.bag", "You take the POO book out of your bag..\n"},
			{"take.book", "\nYou decide to keep the book with you"},
			{"dec.course", "\nYour energy level decreased by "},
			{"energy.lvl", "Your current energy level : "},
			{ "bad.exam", "Exam : " },
            { "bad.msg", " You don't have to stay...\n" },
            { "quest.1", "Interpretation programs is done by JVM" },
            { "ans.1", "true" },
            { "quest.2", "Object class has a superclass" },
            { "ans.2", "false"},
            { "quest.3", "An interface can be instantiated" },
            { "ans.3", "false"},
            { "quest.4", "The Car class extends the Vehicle class .\nThe declaration Vehicle c = new Car(); is correct." },
            { "ans.4", "true" },
            { "quest.5", "Consider the following code\npublic class Bogus {int x;};\nThe declaration Bogus(a) = new Bogus(3); is correct." },
            { "ans.5", "false"},
            {"ans.was", "The answer was : "},
            { "win.game", "Congratulations, you've passed your exam with " },
            { "lose.game", "Go back to classes, you've failed your exam with " },
            {"exam.impossible", "You can't pass the exam, make sure you attended all the lectures and labs, go drink a coffee, and then come back !"},
            {"start.exam", "\nYou are just in time for your POO exam..\nAnswer by true or false.."},
            {"help.sheet", "The answer is on the sheet you found before :"},
            {"finish.game", "You ended the game, thank you for playing, good bye !"},
            {"finish.lose", "You've lost the game, but thank you for playing, good bye !"},
            {"go.sleep", "You are very tired, you decide to sleep a bit in order to get back 50 energy points !"},
            {"new.energy", "Your new energy level : "}
	};
	
	
	@Override
	public Object[][] getContents() {
		return contents;
	}
}
