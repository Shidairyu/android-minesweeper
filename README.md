# android-minesweeper
## Description
Our own implementation of the legendary Minesweeper game inside an Android App. <br>
It includes varying difficulties to choose from and a high-score list to check out your best runs.
A simple help page explains the games mechanics and the other parts of the app.
There is also an included darkmode to lessen the strain on your eyes (especially at night 😉) 

## Which points we want to achieve

| Description                                                                 |   Points    |
|:----------------------------------------------------------------------------|:-----------:|
| Screen: Start                                                               |      1      |
| Screen: New Game and Game                                                   |    1 + 4    |
| Jetpack-component: `RecyclerView` (In `BoardAdapter` and `HigscoreAdapter`) |      2      |
| Screen: High-score                                                          |      2      |
| Screen: Help page                                                           |      2      |
| Jetpack-component: `ViewPager2` in `HelpViewPagerAdapter`                   |      2      |
| Usage of Kotlin                                                             |      6      |
| Persistence: High-score list using `Room` database                          |      3      |
| Persistence: Darkmode settings                                              |      1      |
| View binding                                                                |      2      |
| Dark theme                                                                  |      1      |
| <h4>Total</h4>                                                              | <h4>27</h4> |

## Screenshots
### Start-Screen
<div float="left"> 
<img src="pictures/startscreen_light.png" width="250" />
<img src="pictures/startscreen_dark.png" width="250" />
</div>

<br>

--- 


### New Game and Game screens
<div float="left"> 
<img src="pictures/newgame.png" width="250" />
<img src="pictures/gamescreen.png" width="250" />
</div>

<br>

--- 
### High-Score and Help
<div float="left"> 
<img src="pictures/highscore.png" width="250" />
<img src="pictures/help.png" width="250" />
</div>

<br>

--- 
### Game Over
<div float="left"> 
<img src="pictures/gameoverlost.png" width="250" />
<img src="pictures/gameoverwin.png" width="250" />
</div>
