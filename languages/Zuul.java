package languages;

import java.util.ListResourceBundle;

import zuul.commands.CommandWord;

/**
 * This class contains all the traduction of the game in french
	@author Nicolas HORY and Cindy NAJJAR
*/

public class Zuul extends ListResourceBundle {
	static final Object[][] contents = {
		{"game.welcome", "Bienvenue dans le monde de Zuul !"},
		{"game.desc", "Le monde de Zuul est un nouveau jeu d'aventure, extrêmement ennuyeux."},
		{"game.help", "Tapez '" + CommandWord.HELP + "' si vous avez besoin d'aide!"},
		{"game.unknown", "Je ne comprends pas ce que vous voulez faire.."},
		{"game.lunch", "Vous n'êtes pas dans la cafétéria, vous ne pouvez pas jouer !"},
		{"help.first", "Vous êtes perdu. Vous êtes seul."},
		{"help.second", "Vous errez autour de l'université."},
		{"help.third", "Vos commandes disponibles sont:"},
		{"light.prob", "Il n'y a pas d'interrupteur dans "},
		{"desc.cor1", "le couloir 1 avec des salles de cours et de TP"},
		{"desc.cor2", "le couloir 2 avec une salle d'examen et des endroits où vous détendre"},
		{"desc.lab", "la salle de TP, préparez vous pour une séance !"},
		{"desc.amphi1", "le premier amphithéatre"},
		{"desc.amphi2", "le second amphithéatre"},
		{"desc.exam", "la salle d'examen"},
		{"desc.lunch", "la cafétéria"},
		{"desc.lib", "la bibliothèque"},
		
		{"game.end", "Merci d'avoir joué. Au revoir."},
		{"go.error", "Aller où ?"},
		{"go.door", "Il n'y a pas de porte !"},
		{"play.no", "\nPersonne n'est la pour jouer au babyfoot, mais vous pouvez vous entraîner tout seul si vous voulez en tapant \"play\"!"},
		{"play.yes", "\nVos deux meilleurs amis sont là, c'est parti pour une partie de babyfoot !"},
		{"pick.error", "Vous devez tout ramasser d'un coup !"},
		{"pick.done", "Vous venez de ramasser tous les objets de la salle ! "},
		{"list.item", "Votre inventaire actuel contient : "},
		{"pick.light", "Vous ne voyez même pas les objets, comment les ramasser ?"},
		{"lib.error", "La bibliothèque est actuellement fermée, revenez plus tard !"},
		{"desc.room", "Vous êtes dans "},
		{"play.baby", "Vous jouez actuellement au babyfoot, et allez oublier un cours !\n"},
		{"forgot.course", "Vous venez d'oublier le cours de "},
		
		{"light.yes", "La lumière est allumée !"},
		{"light.no", "La lumière est éteinte !"},
		{"pick.nothing", "Il n'y a aucun objet à ramasser !"},
		{"quit.error", "Quitter quoi ?"},
		{"room.obj", "Objets présents dans la salle : "},
		{"obj.error", "Aucun objet"},
		{"drink.error", "Vous ne pouvez pas boire de café en dehors de la cafétéria !"},
		{"drink.cof", "Vous venez de boire un café. Vous avez désormais "},
		{"energy.pts", " points d'énergie !"},
		{"error.cof", "Vous ne pouvez pas boire de café, vous n'en avez pas !"},
		{"play.tablet", "Vous venez d'allumer votre tablette !"},
		{"video.game", "La tablette ouvre un jeu vidéo.."},
		{"play.zuul", "Vous avez joué à World of Zuul, ce qui n'a aucun impact sur vos connaissances"},
		{"play.game", "Vous avez joué à un jeu vidéo pas très instructif..."},
		{"no.tablet", "Vous n'avez même pas de tablette pour jouer !"},
		{"tablet.learn", "Votre tablette ouvre Internet sur la page web de l'université contenant des cours et TP !"},
		
		{"POO.enum", "POO"},
		{"ALGO.enum", "ALGO"},
		{"MATHS.enum", "MATHS"},
		{"POO.course0", "\"Si deux classes dépendent beaucoup l'une de l'autre, on dit qu'elle sont très liées. \n Nous voulons éviter cela !\"\n"},
		{"POO.course1", "\"Si chaque méthode gère une tâche bien définie, on dit qu'elle a une grande cohésion. \nC'est ce que nous voulons !\"\n"},
		{"POO.course2", "\"Les classes ne doivent représenter qu'une seule entité bien définie. \nUne méthode ne doit gérer qu'une tâche bien définie.\"\n"},
		{"POO.lab0", "\"La meilleure façon d'éviter la dépendance\n entre classes est d'en définir une pour chaque entité du projet.\"\n"},
		{"POO.lab1", "\"Un moyen pour avoir de la cohésion \nest de définir toutes les tâches, et de créer les méthodes ensuite.\"\n"},
		{"POO.lab2", "\"Quand vous programmez en Java, vous pouvez faire un diagramme UML afin d'organiser vos idées.\"\n"},
		
		{"all.lect", "Les cours auxquels vous avez assisté : "},
		{"all.lab", "Les TP auxquels vous avez participé : "},
		{"forgot.course", "Vous venez d'oublier ce cours : "},
		{"forgot.lab", "Vous venez d'oublier ce TP : "},
		{"learn.lab", "Vous venez d'assister au TP : "},
		{"learn.lect", "Vous venez d'assister au cours : "},
		{"know.lect", "Vous avez déjà suivi le cours : "},
		{"unk.lect1", "Vous ne pouvez pas faire le TP "},
		{"unk.lect2", " sans avoir suivi le cours correspondant !"},
		{"bad.lect", "Vous pouvez ressortir, vous n'avez pas à suivre le cours de "},
		{"bad.lab", "Vous pouvez ressortir, vous n'avez pas à suivre le TP de "},
		{"know.lab1", "Vous avez déjà suivi le TP "},
		{"know.lab2",", vous pouvez sortir !"},
		{"no.lects", "Aucun cours"},
		{"no.labs", "Aucun TP"},
		{"tab.prob", "Le cours que vous venez de lire n'était pas de la POO, donc ca ne vous intéresse pas !"},
		{"lab.present", "\nLe professeur entre pour votre TP :"},
		{"lect.present", "\nLe professeur entre pour votre cours :"},
		{"room.exits", "Les sorties possibles de la salle : "},
		{"empty.inv", "Votre inventaire actuel est vide."},
		{"no.lectures", "Vous ne pouvez pas oublier de cours car vous n'en avez pas encore suivi !"},
		{"read.book", "Vous venez de lire le livre de POO, ce qui vous a permis d'en apprendre tous les cours !"},
		{"book.prob", "Vous ne pouvez pas lire de livre, vous n'êtes pas dans la bibliothèque et vous ne l'avez pas emprunté !"},
		{"will.read", "Vous ouvrez le livre de POO..."},
		{"book.bag", "Vous sortez le livre de POO de votre sac..\n"},
		{"take.book", "\nVous décidez de garder le livre avec vous"},
		{"dec.energy", "\nVotre niveau d'énergie a baissé de "},
		{"energy.lvl", "Votre énergie actuelle : "},
		{ "bad.exam", "Exam : " },
        { "bad.msg", " Vous n'êtes pas obligé de rester...\n" },
        { "quest.1", "L'interprétation des programmes Java est effectuée par JVM" },
        { "ans.1", "vrai" },
        { "quest.2", "La classe Object a une classe mère" },
        { "ans.2", "faux"},
        { "quest.3", "Une interface peut être instanciée" },
        { "ans.3", "faux"},
        { "quest.4", "La classe Car hérite de Vehicle.\nLa déclaration Vehicle c = new Car(); est correcte." },
        { "ans.4", "vrai" },
        { "quest.5", "Considérons le code\npublic class Bidon {int x;};\nLa déclaration Bidon(a) = new Bidon(3); est correcte." },
        { "ans.5", "faux"},
        {"ans.was", "La réponse était : "},
        {"win.game", "Félicitations, vous avez réussi votre exam avec "},
        {"lose.game", "Retournez réviser, vous avez raté votre exam avec "},
        {"exam.impossible", "Vous ne pouvez pas passer l'exam, vérifiez que vous avez assisté à tous les cours et TP, allez boire un café, et revenez ensuite ! !"},
        {"start.exam", "\nVous arrivez juste à temps pour votre examen de POO..\nRépondez par vrai ou faux.."},
        {"help.sheet", "La réponse est notée sur l'antisèche que vous avez trouvée :"},
        {"finish.game", "Vous avez fini le jeu, merci d'avoir joué, au revoir !"},
        {"finish.lose", "Vous avez donc perdu la partie, merci quand même d'avoir joué, au revoir !"},
        {"go.sleep", "Vous êtes très fatigué, vous décidez de dormir un peu pour récupérer 50 points d'énergie !"},
        {"new.energy", "Votre nouveau niveau d'énergie : "}
};
	
	@Override
	public Object[][] getContents() {
		return contents;
	}
}
