# Basic Blackjack Simulation

[TODO]: # (Change README.md Headline to better fit to your project!)

This repository contains a student project created for an ongoing lecture on object-oriented programming with Java at HWR Berlin (summer term 2022).

> :warning: This code is for educational purpose only. Do not rely on it!

## Abstract

This project deals with a blackjack simulation. A blackjack instance can be created and players can be added.
These players randomly set their stakes above the minimum stake. If a player does not meet the minimum stake,
he is eliminated from the game. After the players have placed their stakes, the dealer draws his first card
and reveals it. Then all players draw two cards. From then on, the player automatically decides whether or not
to continue drawing, according to the logic of whether or not his hand count is less than or equal to 16. As
soon as all players no longer want to draw, the dealer draws according to the same logic. When the dealer has
finished, the handcounts of the players are compared with those of the dealer. Players who win get their stake
added to their bankroll. Players who lose get their stake deducted from their bankroll. In this simulation,
an ace can also have the value 1 or 11, depending on what suits the handcount of the player or dealer better.

[TODO]: # (Write a short description of your project.)
[TODO]: # (State most important features.)
[TODO]: # (State the most interesting problems you encountered during the project.)
One of the biggest problems was to decide what to return on dealer.dealCard() when the card deck is empty.
Returning null was our first approach, but this lead to unexpected behavior and NullPointerExceptions.
Then we thought about using the optional wrapper, 
but this option would introduce so much overhead, 
because we would still need to check whether a card is present or not to then call dealer.dealCard().get().
At the end we decided to throw an EmptyCardDeckException when the card deck is empty,
because it makes the code so much cleaner and should never happen in a real game.
Another problem we faced was deciding whether player bets and the decision whether the player still wants to draw cards should be entered manually or whether the programme should make the decisions automatically.
Since the focus of the project was on tests, we decided to have the programme randomise the stakes and have the players play according to realistic logic that applies to dealers in casinos.

The project consists of three key features. First, one can create a blackjack game including a dealer. When creating the game one must give the game's minimum stake.
In the next step, one must add players (can also be only one) with individual names and bankrolls to the game. Once players are added to the game it can be started.
The players make decisions with artificial intelligence over the cause of the game. They decide whether to continue drawing cards or to stop hitting. 
After each round the player's hand counts are compared to the dealer's. When a player lost too much of his money, the player gets removed from the game.

## Feature List

[TODO]: # (For each feature implemented, add a row to the table!)

| Number | Feature                           | Tests |
|--------|-----------------------------------|-------|
| 1      | create Blackjack Game with Dealer |  yes    |
| 2      | add AI Players                    |   yes   |
| 3      | run multiple Games                |  yes    |


## Additional Dependencies

[TODO]: # (For each additional dependency your project requires- Add an additional row to the table!)

| Number | Dependency Name | Dependency Description | Why is it necessary?                                                                 |
|--------|-----------------|------------------------|--------------------------------------------------------------------------------------|
| 1      | List               | Interface of a List                      | Could be exchanged with linked list, performace wise                                 |
| 2      | ArrayList               | Specific implementation of a List                      | Stores the dealers card deck, his and the players hands and the players in Blackjack |
| 3      | Random               | Can create random Numbers                      | Used to draw a random card and to allow players to make desicions                    |






