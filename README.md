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
And the reason why it is necessary to have the exact number of, for example, gadgets and gears is because in the game, each brawler has exactly two gadgets and star powers and exactly six gears (some of the brawlers have more gears, but the devs are removing some of them to leave only six, but in my project I determined this amound as six to make things easier).

# Director: preset brawlers and demonstration

On this step I added a new director class - BrawlerDirector. It is pretty simple since it just has methods for constructing brawlers and does just this. But one thing I wanted to demonstrate here is that not every field is necessary to be filled. In these examples I have Shelly, who doesn't have any traits, Bull, who has every piece of his build and Cosmo, who doesn't have nor traits, hypercharge amd buffies.

# Client: run and brawl

This step is the simpliest one. The client is class that runs all the builders and directors. Its purpose is to run the process of construction and use the constructs taking this responsibility. In my project, it mainly serves as a main class, but in more complex projects it might be different. I added the greet() method to Brawler class to give them some actions and fixed some critical bugs.

# Clean Code principles

## Meaningful, intention-revealing names for classes/methods/variables

Before:
```java
BrawlerBuilder b = new BrawlerBuilder();
BrawlerDirector d = new BrawlerDirector(b);
```

After:
```java
BrawlerBuilder builder = new BrawlerBuilder();
BrawlerDirector director = new BrawlerDirector(builder);
```

Before:
```java
Brawler a = director.build1();
```

After:
```java
Brawler shelly = director.constructShelly();
```

> Using meaningful and intention-revealing names helps to identify what code does without notes or looking through it every time

## Small methods, each doing one thing

```java
public Brawler constructCosmo() {
    return builder.name("Cosmo")
            .base_attack(new String[]{"Orbit"})
            .super_attack(new String[]{"Gravitational Pull"})
            .gadgets(new String[]{"Planetary Pushback", "Telescope Trap"})
            .gears(new String[]{"Speed", "Vision", "Health", "Shield", "Damage", "Gadget Cooldown"})
            .star_powers(new String[]{"Precession", "Ammo Attraction"})
            .build();
}
```

> The ```constructShelly()``` method has one focused responsibility: it defines parameters and constructions sequence for Shelly and returns the Brawler. The construction is made by the BrawlerBuilder class only

## Consistent formatting and small, focused classes

- Brawler.java
- BrawlerBuiilder.java
- BrawlerDirector.java
- BrawlerClient.java

> Each class has its own focused role and resposibilities in the builder pattern

## Validated construction

```java
if (name == null || name.isBlank()) {
    throw new IllegalArgumentException("Name cannot be null or blank");
}

if (base_attack == null || base_attack.length == 0) {
    throw new IllegalArgumentException("Base attack cannot be null or empty");
}
```

> Validated constructions helps to understand what is expected, makes debugging easier and shows what is necessary and what is not

## No magic numbers/strings

Before:
```java
if (gadgets == null || gadgets.length != 2) {
    throw new IllegalArgumentException("Gadgets cannot be null and must have exactly 2 elements");
}

if (gears == null || gears.length != 6) {
    throw new IllegalArgumentException("Gears cannot be null and must have exactly 6 elements");
}

if (star_powers == null || star_powers.length != 2) {
    throw new IllegalArgumentException("Gadgets cannot be null and must have exactly 2 elements");
}
```

After:
```java
if (gadgets == null || gadgets.length != MAX_GADGETS) {
    throw new IllegalArgumentException("Gadgets cannot be null and must have exactly " + MAX_GADGETS + " elements");
}

if (gears == null || gears.length != MAX_GEARS) {
    throw new IllegalArgumentException("Gears cannot be null and must have exactly " + MAX_GEARS + " elements");
}

if (star_powers == null || star_powers.length != MAX_STAR_POWERS) {
    throw new IllegalArgumentException("Star powers cannot be null and must have exactly " + MAX_STAR_POWERS + " elements");
}
```

> Avoiding magic numbers and strings not only makes the code more flexible and easier to write, but also makes it easier to navigate and understand what these number/strings do