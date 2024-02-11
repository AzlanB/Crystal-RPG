import java.util.Random;
/**
 * A class used for generating random things within the game
 */
public class RNG{
    /**
     * Generates a random number between the min and max, inclusive
     */
    public static int generate(int min, int max){
        Random randomGen = new Random();
        return randomGen.nextInt(max+1-min)+min;
    }

    /**
     * Generates a random number between 2/3 of stat and stat, inclusive
     */
    public static int check(int stat){
        return generate(stat*2/3, stat);
    }

    /**
     * Returns a random enemy name
     */
    public static String enemyName(){
        return switch (RNG.generate(1, 40)) {
            case 1 -> "Tombling";
            case 2 -> "Slaggirl";
            case 3 -> "Vampthing";
            case 4 -> "Cloudsword";
            case 5 -> "The Horrible Weirdo";
            case 6 -> "The Putrid Screamer";
            case 7 -> "The Noxious Body";
            case 8 -> "The Ravaging Spite Panther";
            case 9 -> "The Ebon Nightmare Scorpion";
            case 10 -> "The Obsidian Phantom Ape";
            case 11 -> "Frightsnake";
            case 12 -> "Germcrackle";
            case 13 -> "Tanglebug";
            case 14 -> "Rustchild";
            case 15 -> "The Vengeful Tree";
            case 16 -> "The Dismal Freak";
            case 17 -> "The Rotten Creeper";
            case 18 -> "The Electric Mocking Hog";
            case 19 -> "The Slender Tomb Dog";
            case 20 -> "The Painted Torment Viper";
            case 21 -> "Phantomsoul";
            case 22 -> "Chaosling";
            case 23 -> "Shademirage";
            case 24 -> "Cryptling";
            case 25 -> "The Mean Child";
            case 26 -> "The Infamous Eyes";
            case 27 -> "The Insane Tree";
            case 28 -> "The Ebon World Hound";
            case 29 -> "The White-Eyed Berserker Beast";
            case 30 -> "The Matriarch Preying Sheep";
            case 31 -> "Smogmask";
            case 32 -> "Metalmask";
            case 33 -> "Germlich";
            case 34 -> "Bladeseeker";
            case 35 -> "The Electric Vision";
            case 36 -> "The Bruised Figure";
            case 37 -> "The Bruised Corpse";
            case 38 -> "The Bloodthirsty Dread Dragon";
            case 39 -> "The Rabid Cave Lizard";
            default -> "The Aquatic Mountain Hippo";
        };
    }

    /**
     * Returns a random battlecry
     */
    public static String battlecry(){
        return switch (RNG.generate(1, 40)) {
            case 1 -> "Let them feel true pain!";
            case 2 -> "We stand together!";
            case 3 -> "In god's name!";
            case 4 -> "Witness our might!";
            case 5 -> "Destroy everything!";
            case 6 -> "They will remember!";
            case 7 -> "Let there be blood!";
            case 8 -> "We shall feast tonight!";
            case 9 -> "Take everything!";
            case 10 -> "We stand united!";
            case 11 -> "For gold and glory!";
            case 12 -> "We are the reapers!";
            case 13 -> "Burn!";
            case 14 -> "Don't run, you're already dead!";
            case 15 -> "Obliterate them from history!";
            case 16 -> "Take what is ours!";
            case 17 -> "Bring me their guts!";
            case 18 -> "By the power bestowed upon us!";
            case 19 -> "Let's teach them how it's done!";
            case 20 -> "For honor!";
            case 21 -> "Thank you for your sacrifice!";
            case 22 -> "Tear them to pieces!";
            case 23 -> "Turn them to ash!";
            case 24 -> "Fire at wilL!";
            case 25 -> "Death to the weak!";
            case 26 -> "For the light!";
            case 27 -> "Until eternity!";
            case 28 -> "God's on our side!";
            case 29 -> "Feel our might!";
            case 30 -> "We have risen!";
            case 31 -> "We ride forever!";
            case 32 -> "Time to have fun!";
            case 33 -> "Swift and savage!";
            case 34 -> "Your souls are ours!";
            case 35 -> "Bring me their teeth!";
            case 36 -> "Blood for the blood god!";
            case 37 -> "To victory!";
            case 38 -> "That one is mine!";
            case 39 -> "The end is here!";
            default -> "SMAAAAAASSHH!!!";
        };
    }

    /**
     * Returns a random name for an NPC
     */
    public static String charName(){
        return switch (RNG.generate(1, 41)) {
            case 1 -> "Beorhthere";
            case 2 -> "Nothwulf";
            case 3 -> "Norbert";
            case 4 -> "Bernulf of Balcombe";
            case 5 -> "Oswin of Drumwyke";
            case 6 -> "Eormenread of Balcaster";
            case 7 -> "Cuthbeorht Tabor";
            case 8 -> "Ealdwulf Foal";
            case 9 -> "Earpwald the Plummer";
            case 10 -> "Hethin the Soppner";
            case 11 -> "Wulfgar";
            case 12 -> "Theodbald";
            case 13 -> "Hygbald";
            case 14 -> "Winegar of Strathstead";
            case 15 -> "Unwona of Penness";
            case 16 -> "Botwine of Lhanshaw";
            case 17 -> "Blithweard Leadbetter";
            case 18 -> "Rumwold Hogg";
            case 19 -> "Turold the Kantor";
            case 20 -> "Sigewine the Warner";
            case 21 -> "Bricthled";
            case 22 -> "Heahthryth";
            case 23 -> "Aelfgifu, wife of Winelac";
            case 24 -> "Edwen, wife of Felgild";
            case 25 -> "Beornwynn of Nantketh";
            case 26 -> "Sidwell of Kylewold";
            case 27 -> "Botild Bacchus";
            case 28 -> "Estrid Potter";
            case 29 -> "Leoflaed the Turner";
            case 30 -> "Wigburg the Faulkner";
            case 31 -> "Aldreda";
            case 32 -> "Aethelwaru";
            case 33 -> "Botild, wife of Sabert";
            case 34 -> "Hildilid, wife of Aethelwold";
            case 35 -> "Cyniburg of Strathshaw";
            case 36 -> "Cuthburga of Porthhope";
            case 37 -> "Britheva Cherrier";
            case 38 -> "Touilt Coldren";
            case 39 -> "Stanfleda the Brewer";
            case 40 -> "Withburga the Sawyer";
            default -> "Projekt Melody";
        };
    }

    /**
     * Returns a random description for an NPC
     */
    public static String charDesc(){
        return switch (RNG.generate(1, 21)) {
            case 1 -> "He has short, wavy, blond hair and golden eyes.";
            case 2 -> "He has very long, curled, auburn hair and gray eyes.";
            case 3 -> "He has extremely long, curled, brown hair shaved on both side and gray eyes.";
            case 4 -> "She has short, straight, gray hair and blue eyes.";
            case 5 -> "He has long, straight, black hair and green eyes.";
            case 6 -> "She has cropped, black mohawk and red eyes.";
            case 7 -> "He has long, wavy, brown hair and blue eyes.";
            case 8 -> "She has short, straight, auburn hair and blue eyes.";
            case 9 -> "He has long, straight, gray hair and green eyes.";
            case 10 -> "She has cropped, wavy, red hair and brown eyes.";
            case 11 -> "He has long, straight, gray hair and blue eyes.";
            case 12 -> "She has long, straight, white hair and brown eyes.";
            case 13 -> "She has long, straight, blond hair and brown eyes.";
            case 14 -> "He has extremely long, wavy, red hair and gray eyes.";
            case 15 -> "He has a bald head and brown eyes.";
            case 16 -> "She has long, dyed green mohawk and brown eyes.";
            case 17 -> "She has very long, wavy, green hair and blue eyes.";
            case 18 -> "She has long, straight, red hair and brown eyes.";
            case 19 -> "She has cropped, wavy, white hair and brown eyes.";
            case 20 -> "She has long, curled, gray hair and red eyes.";
            default -> "She is a robotic humanoid with blue hair and purple eyes.";
        };
    }

    /**
     * Returns a random name for a town
     */
    public static String locName(){
        return switch (RNG.generate(1, 41)) {
            case 1 -> "Wildeholde";
            case 2 -> "Ironview";
            case 3 -> "Dogtide";
            case 4 -> "Heartstrand";
            case 5 -> "Swampcall";
            case 6 -> "Wildestar";
            case 7 -> "Lastshade";
            case 8 -> "Dusktown";
            case 9 -> "Blindrock";
            case 10 -> "Springharbor";
            case 11 -> "Arrowspire";
            case 12 -> "Riverham";
            case 13 -> "Gloomfall";
            case 14 -> "Direshade";
            case 15 -> "Elderwind";
            case 16 -> "Southacre";
            case 17 -> "Hazelland";
            case 18 -> "Shroudwell";
            case 19 -> "Madhand";
            case 20 -> "Houndpeak";
            case 21 -> "Houndvein";
            case 22 -> "Bronzehall";
            case 23 -> "Edgeguard";
            case 24 -> "Bellwall";
            case 25 -> "Edgehorn";
            case 26 -> "Maplechill";
            case 27 -> "Shademire";
            case 28 -> "Reddale";
            case 29 -> "Sleekwich";
            case 30 -> "Cloudwatch";
            case 31 -> "Cloudmeadow";
            case 32 -> "Stormwick";
            case 33 -> "Lostvale";
            case 34 -> "Rustpeak";
            case 35 -> "Snakeholde";
            case 36 -> "Smoothmire";
            case 37 -> "Whitehaven";
            case 38 -> "Shadowmire";
            case 39 -> "Basincliff";
            case 40 -> "Whalewallow";
            default -> "https://youtu.be/T9DgaK1ZoeA";
        };
    }

    /**
     * Returns a random description for a town
     */
    public static String townDesc(){
        return switch (RNG.generate(1, 27)) {
            case 1 -> "Below the sands of the hottest desert lies the city. Days and nights are\ntoo hot for most, so the city has been built beneath the surface to\nescape the heat. Only once a night do the doors to the outside open to let\npeople in and out and replenish supplies. Any longer and the increasing temperatures\nwill ruin the gentle, underground climate so many now rely on.";
            case 2 -> "Traders from far and wide come to buy and sell exotic creatures for all\nkinds of purposes. Circus shows, zoos, personal pets, exotic toxins and\nmuch more can all be gained. The true monsters, however, are the traders\nthemselves who often handle the creatures with cruel hands.";
            case 3 -> "Like a great festival, the city is conjured twice a year to celebrate\nmusic, spread knowledge gained over the previous 6 months, recruit new\nmagicians, and far more. Magical spectacles, duels, classes and all sorts of\nother treats and delights can be found, so there's plenty to do for both masters and novices alike.";
            case 4 -> "Underground waters at higher temperatures provide a great way to heat the\ncity, part of the icy climate. But once in a while a geyser will spew\nhot water into the air, which catches many visitors by surprise and causes\nthe occasional damage.";
            case 5 -> "Here, status is everything. The higher you climb the social ladder, the\nfurther from the core of the seemingly endless layers of city walls you\ncan live. The closer to the center, the worse of you are. The edge is where\ngoods are delivered fresh and daily, where those at the top have first choice and\ndiscard everything else to the next layer of wall.";
            case 6 -> "This is a city of breweries, distilleries and other alcohol production\nbusinesses. People often joke the fumes from these businesses makes the\ncows in the fields just outside of the city drunk, but how true this is\nremains a tale wrapped in truths and urban legends. It's not for the drunken cows people\nvisit though, it's the wide selection of often cheap beverages of course.";
            case 7 -> "Here, champions of all sorts are treated like kings. Their desires and\nwishes are the commands of many, but lose your champion's title and you'll\nbe kicked out or forced to serve the newly crowned champion.";
            case 8 -> "It's unsure whether this city was built around nature or nature was built\naround it, but the city is one gigantic garden with everything you could\nimagine in a garden as well as homes, stores, businesses and other\nelements you'd commonly find in a city. Insects, leaves, shade, beauty and sweet scents are all around.";
            case 9 -> "This is a new city built with careful planning and future generations in\nmind. To some it's seen as a flawless city, to others it's too artificial\nand lacks a soul. Either way, other cities can learn a thing of two from\nthis city in some areas like waste management and city planning. Other elements,\nlike aesthetics, remain a subjective topic.";
            case 10 -> "This city can barely be called a city, it's more of a central hub of the\nworld. Portals from around the world connect to here, and this city\nconnects the world to itself in doing so. Commerce takes advantage of this of\ncourse, but few people stay for long, there's simply too much to see in the world.";
            case 11 -> "What was once a booming city with a stray cat problem turned into a city\nhome to strays of all kind. Animals, humanoids and others are all\nwelcome. The city embraced its strays rather than getting rid of them, offering\nthem a place in the world when nowhere else would.";
            case 12 -> "Haven and prison, this city is home to countless dead and undead beings\nwho were either banished here or sought a life here of their own volition.\nThis collection of beings some would call heinous or unnatural often\nbrings trouble with it as there are plenty who seek to rid the world of this place.";
            case 13 -> "This city was built without enough planning. Higher and bigger were the\ntheme for a long time, so many buildings rise high up into the sky. With\nthe sun low on the horizon no light penetrates to the streets below and\nstreet lights are on virtually 24/7. But some take advantage of this eternal nightlife.";
            case 14 -> "To the uninitiated this city may seem like a strange, barren place. Empty\nbuildings somehow have plenty of people in them, just laughing or living\nlife in a place devoid of anything. But the initiated know they live in\na virtual reality. Buildings change every day in the virtual world and will become whatever\nis needed. A conference room, a nightclub or simply a dining room with family far away, all is possible here.";
            case 15 -> "Saying the people of this city are reserved is putting things lightly.\nThey keep to themselves, don't celebrate holidays, virtually avoid all eye\ncontact and keep social interactions to a minimum. A haven for some, a\nplace of loons to others.";
            case 16 -> "Year after year, the city is carved and built into the clean snows and\nices. Come spring, the city melts and ceases to exist until winter returns.";
            case 17 -> "Many decades ago the city was divided into 5 sections after a war resulte\nin the overthrowing of a dictator. The 5 kings who did the conquering\nwere all eager to take control of this rich city, but had to settle for a\nfifth of it each. Each king lives in their section as a show of ownership and an attempt\nto win the public in their favor.";
            case 18 -> "In an unusual valley a grass species grows unlike any other. Each day it\ngrows up to 2 feet, yet people decided to build a city within these\ngrasses. But rather than getting rid of them all, the grasses were left in\nplace. Each week roads change as people carve new paths through the fast growing blades.\nOccasionally people are caught by surprise by hiding animals or even each other as grasses are suddenly cut right in front of them.";
            case 19 -> "This city has long been the home of the largest tribunal in the country,\nbut has grown over the years to become a center for criminal\ninvestigation, enactment of justice and everything else that has to do with it.\nThieves and criminals have no place in this city other than in handcuffs, but that doesn't\nmean some won't try what they see as the ultimate challenge.";
            case 20 -> "The old, sick and otherwise dying often end up here for one reason or\nanother. Fear, indifference, lack of money, it doesn't matter, the citizens\nare all left to their own devices. Despite this they persevere, even if\nonly shortly for some.";
            case 21 -> "A climate favorable to some, unfavorable to others, and a landscape that\namplifies the rainy side of this climate are all that's needed for the\ncity to be almost continuously under the spell of rain. The city makes full\nuse of the rain though. From water transportation systems to areas with musical effects\nfrom the raindrops, and from farm irrigation systems to aquacultures.";
            case 22 -> "Strictly speaking, this city isn't invisible, just hidden. A thick layer\nof fog penetrates even the deepest parts of the city on most days of the\nyear. Seeing anything at all is difficult beyond a few meters, so a large\ncity can quickly seem like merely a neighborhood if you don't venture far.";
            case 23 -> "This city was once a beautiful city rich in trade, people and dreams, but\na volcanic eruption destroyed this all. Instead of moving to a different\nlocation, survivors built a new city from the ashes of the old. Remnants\nof the disaster still linger behind every corner, but this place rises further and further each day.";
            case 24 -> "Cogs, wheels, steam and other technology powers everything in this city.\nFrom the city walls to the supply carts, from the clock-tower to the city\nhall, and from personal transportation to personal care. Both the lazy\nand the creative seek this town for their own reasons, while others tend to stay far, far away.";
            case 25 -> "Dark desires are a regular commodity here. Drugs, alcohol, gambling,\ndeviant pleasures and far, far more is all for the taking here, but be aware\nfor others may seek to take you for their own deviant desires.";
            case 26 -> "The city seems completely out of place. Nothing is around for miles upon\nmiles upon miles, yet the city stands tall and proud in the middle of\nnowhere. It's often dubbed The Lonely City because it is all alone in its\nsurroundings, but the citizens are anything but alone.";
            default -> "A long standing tradition originating from a trade agreement has resulted\nin the city being built entirely from a local wood. Stone buildings are\nforbidden by law to uphold this old tradition, and some take it a step\nfurther by banning all non-wood construction materials from their businesses. Not all do of\ncourse, but it can be a laborious task to find comfort some are familiar with when visiting.";
        };
    }

    /** 
     * Returns a random quest location based on the player's level
     */
    public static QuestLocation randQLoc(int level){
        return switch (RNG.generate(1, 5)) {
            case 1 -> new QuestLocation(locName(), "A ruined ghost town", new Item("Gold Key", "An ornate key made of gold", level * 3, false), "There is a chest with a large, golden key hole", randItem(level), "You slot in the key and turn it. Inside the chest is an item");
            case 2 -> new QuestLocation(locName(), "A ruined ghost town", new Item("Silver Key", "An ornate key made of silver", level * 3, false), "There is a chest with a large, silver key hole", randItem(level), "You slot in the key and turn it. Inside the chest is an item");
            case 3 -> new QuestLocation(locName(), "A ruined ghost town", new Item("Brass Key", "An ornate key made of brass", level * 3, false), "There is a chest with a large, brass key hole", randItem(level), "You slot in the key and turn it. Inside the chest is an item");
            case 4 -> new QuestLocation(locName(), "A ruined ghost town", new Item("Platinum Key", "An ornate key made of platinum", level * 3, false), "There is a chest with a large, platinum key hole", randItem(level), "You slot in the key and turn it. Inside the chest is an item");
            default -> new QuestLocation(locName(), "A ruined ghost town", new Item("Bronze Key", "An ornate key made of bronze", level * 3, false), "There is a chest with a large, bronze key hole", randItem(level), "You slot in the key and turn it. Inside the chest is an item");
        };
    }

    /**
     * Returns a random item based on the player's level
     */
    public static Item randItem(int level){
        switch (RNG.generate(1, 7)){
            case 1:case 2:
            int slot = RNG.generate(0, 5), stat = RNG.generate(0, 4);
            String name = "", desc = "";
            switch (slot){
                case 0: name += "Healm of "; desc += "A headgear that increases "; break;
                case 1: name += "Amulet of "; desc += "A neckless that increases "; break;
                case 2: name += "Breastplate of "; desc += "A chestpiece that increases "; break;
                case 3: name += "Orb of "; desc += "A holdable item that increases "; break;
                case 4: name += "Ring of "; desc += "A ring that increases "; break;
                case 5: name += "Boots of "; desc += "A set of boots that increases "; break;
            }
            switch (stat){
                case 0: name += "Power"; desc += "Strength"; break;
                case 1: name += "Speed"; desc += "Agility"; break;
                case 2: name += "Shielding"; desc += "Defense"; break;
                case 3: name += "Vitality"; desc += "Health"; break;
                case 4: name += "Beauty"; desc += "Charm"; break;
            }
            return new Equipment(name, desc, level*10, true, slot, stat, (int)(level*1.5));
            case 3:case 4: 
            switch (RNG.generate(1, 5)){
                case 1: return new DamagingItem("Shock Bomb", "A small, throwable device that shocks the target", level*10, 1, level*4, 85, true);
                case 2: return new DamagingItem("Hyper Dart", "An incredible sharp dart, capable of killing any foe, but hard to hit", level*20, 1, level*1000, 40, false);
                case 3: return new DamagingItem("Grenade", "A small, throwable explosive", level*10, 1, level*4, 100, false);
                case 4: return new DamagingItem("Gravity Cannon", "A cannon, cabable of huge amounts of force", level*10, 1, level*4, 100, false);
                default: return new DamagingItem("Fire Bomb", "A small, throwable incindiary", level*10, 1, level*4, 100, true);
            }
            case 5:case 6: 
            switch (RNG.generate(1, 10)){
                case 1: return new BuffingItem("Potion of Strength", "A three use potion that boosts strength", level*10, 3, 0, (int)(level*1.5));
                case 2: return new BuffingItem("Potion of Agility", "A three use potion that boosts agility", level*10, 3, 1, (int)(level*1.5));
                case 3: return new BuffingItem("Potion of Defense", "A three use potion that boosts defense", level*10, 3, 2, (int)(level*1.5));
                case 4: return new BuffingItem("Potion of Health", "A three use potion that heals", level*10, 3, 3, (int)(level*1.5));
                case 5: return new BuffingItem("Potion of Charm", "A three use potion that boosts charm", level*10, 3, 4, (int)(level*1.5));
                case 6: return new BuffingItem("Scroll of Strength", "A one use scroll that boosts strength", level*10, 3, 0, (int)(level*1.5));
                case 7: return new BuffingItem("Scroll of Agility", "A one use scroll that boosts agility", level*10, 3, 1, (int)(level*1.5));
                case 8: return new BuffingItem("Scroll of Defense", "A one use scroll that boosts defense", level*10, 3, 2, (int)(level*1.5));
                case 9: return new BuffingItem("Scroll of Health", "A one use scroll that heals", level*10, 3, 3, (int)(level*1.5));
                default: return new BuffingItem("Scroll of Charm", "A one use scroll that boosts charm", level*10, 3, 4, (int)(level*1.5));
            }
            default: 
            switch (RNG.generate(1, 5)){
                case 1: return new Item("Gold Key", "An ornate key made of gold", 70, false);
                case 2: return new Item("Silver Key", "An ornate key made of silver", 50, false);
                case 3: return new Item("Brass Key", "An ornate key made of brass", 30, false);
                case 4: return new Item("Platinum Key", "An ornate key made of platinum", 70, false);
                default: return new Item("Bronze Key", "An ornate key made of bronze", 20, false);
            }
        }
    }

    /**
     * Returns a random item that isn't equipment or a consumable based on the player's level
     */
    public static Item randQItem(int level){
        return switch (RNG.generate(1, 5)) {
            case 1 -> new Item("Gold Key", "An ornate key made of gold", 70, false);
            case 2 -> new Item("Silver Key", "An ornate key made of silver", 50, false);
            case 3 -> new Item("Brass Key", "An ornate key made of brass", 30, false);
            case 4 -> new Item("Platinum Key", "An ornate key made of platinum", 70, false);
            default -> new Item("Bronze Key", "An ornate key made of bronze", 20, false);
        };
    }
}