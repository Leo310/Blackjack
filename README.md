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
added to their bankroll. Players who have lost get their stake deducted from their bankroll. In this simulation,
an ace can also have the value 1 or 11, depending on what suits the handcount of the player or dealer better.

[TODO]: # (Write a short description of your project.)
[TODO]: # (State most important features.)
[TODO]: # (State the most interesting problems you encountered during the project.)
One of the biggest problems was to decide what to return on dealer.dealCard() when the card deck is empty.
Returning null was our first approach, but this lead to unexpected behavior and NullPointerExceptions.
Then we thought about using the optional wrapper, 
but this option would introduce so much overhead, 
because we would still need to check whether a card is present or not to then call dealer.dealCard().get().
At the end we decided to throw a RuntimeException when the card deck is empty,
because it makes the code so much cleaner and should never happen in a real game.

## Feature List

[TODO]: # (For each feature implemented, add a row to the table!)

| Number | Feature | Tests |
|--------|---------|-------|
| 1      | /       | /     |


## Additional Dependencies

[TODO]: # (For each additional dependency your project requires- Add an additional row to the table!)

| Number | Dependency Name | Dependency Description | Why is it necessary? |
|--------|-----------------|------------------------|----------------------|
| 1      | /               | /                      | /                    |





