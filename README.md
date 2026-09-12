## All the steps taken are described here

# Topic and reasons

In the game Brawl Stars there are many brawlers with their own unique abilities. These include:
- Base attack
- Super
- Gadgets
- Gears
- Star powers
- Hypercharge
- Buffies
- Traits

Other characteristicks such as speed, health, damage etc. are not included here and will not be used to avoid overcomlication.
Of course, when you have over one hundred characters with that many abilities, it may become pretty complicated to create their builds and keep track of it.
So, as a veteran player, I would like to use this part of the game as a theme for my task.

# Product: what and why

Each brawler (product) will have seven components leasted earlier plus Name. Each of them, except Hypercharge, are arrays. Some brawlers in the game have abilities to switch forms, as well as attacks (like Bonnie, Starr Nova and Kit), or even different supers (like Kaze). Because of this, these fields will have String[] type. Hypercharge and Name will be just String since there are only one hypercharge per brawler (except some of them because hypercharges for them are not in the game yet) and, of course, one name for each brawler.

# Builder: basics

On this step I added a new builder class - BrawlerBuilder. Here, in the BrawlerBuilder class I didn't write an explicit constructor for it. Its purpose is to create instances of another class, so here an eplicit constructor is optional.
A tiny note about validated construction. In the game, there're abilities that every brawler have. These are base attack, super, gadgets, gears and star powers (and not the ability, name). But there're brawlers that don't have a hypercharge or/and buffies. For example the newest brawler Cosmo by the moment I'm writing this code, doesn't have nor hypercharge and buffies. Because of this, these two fields might be empty, so it is acceptable to have null values there. I'm not being accurate with the game so there will not be a check whether the brawler has a hypercharg or/and buffies, and I think here it is not needed. But I'm keeping the ability to leave these two fields empty to show how the builder pattern works.
And the reason why it is neccesary to have the exact number of, for example, gadgets and gears is because in the game, each brawler has exactly two gadgets and star powers and exactly six gears (some of the brawlers have more gears, but the devs are removing some of them to leave only six, but in my project I determined this amound as six to make things easier).

# Director: preset brawlers and demonstration

On this step I added a new director class - BrawlerDirector. It is pretty simple since it just has methods for constructing brawlers and does just this. But one thing I wanted to demonstrate here is that not every field is neccesary to be filled. In these examples I have Shelly, who doesn't have any traits, Bull, who has every piece of his build and Cosmo, who doesn't have nor traits, hypercharge amd buffies.