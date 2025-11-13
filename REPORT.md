# 2024F CS2910 Project Report
**Group Members**
1. Person 1 (Oluwatomilayo Faloseyi)
2. Person 2 (Kevin Nkosi Davies)

# Summary of Game
Monopoly is a turn-based board game where players compete to accumulate wealth by purchasing, trading, and developing properties while avoiding bankruptcy. 
The game ends when all but one player have gone bankrupt or a specific condition, such as reaching a predetermined number of turns, is met. 
Key objects in the game include the board, players, properties, utilities, and spaces like "Go to Jail" and "Jail." (how to play monopoly link - https://www.wikihow.com/Play-Monopoly). 
We implemented most parts of the game like the properties;to make it interesting, but we left out sections like chance and community chest, due to time constraint.


# Experiment Report
## Player Strategies
_For each of 4 strategies you implemented, name the strategy, and then description of it (100 words each)_
1. Strategy 1: **Collector Strategy**: The Collector Strategy is a focused and goal-driven approach that prioritizes acquiring and upgrading properties of a specific target color. This strategy is particularly suited for players who aim to monopolize properties of a chosen color, maximizing their control over that color group. By doing so, the player can enhance their earning potential through rent collection while creating barriers for opponents attempting to complete color groups. The strategy only considers buying unowned properties of the target color that are affordable, ensuring resource efficiency. Upgrading is also color-specific, making it a well-defined tactic for achieving dominance in the game.
2. Strategy 2: **Cautious Saver Strategy**: The Cautious Saver Strategy is a risk-averse approach designed for players who prioritize financial stability over aggressive expansion. This strategy ensures the player's balance never drops below a predefined safety threshold, providing a financial buffer to handle unexpected expenses or penalties. The player carefully evaluates property purchases, acquiring only unowned properties that align with their budget constraints. Similarly, property upgrades are considered only if the player can afford the upgrade while maintaining the safety buffer. This method is ideal for conservative players who value long-term sustainability and seek to minimize financial risks while steadily building their asset portfolio.
3. Strategy 3: **Disruptive Strategy**: The Disruptive Strategy is designed for players who focus on hindering opponents' progress by strategically owning properties of different colors. This strategy prioritizes diversity in property acquisition, aiming to block other players from completing color sets and gaining monopolies. The player buys unowned, affordable properties only if they belong to a color not yet represented in their portfolio. By spreading ownership across all colors, the strategy disrupts competitors' ability to control key assets. Unlike other strategies, the DisruptiveStrategy does not focus on upgrading properties, as its primary goal is to prevent opponents from capitalizing on their strategies effectively.
4. Strategy 4: **Aggressive Buyer Strategy**: The AggressiveBuyerStrategy represents a bold and assertive approach to gameplay. Players employing this strategy prioritize acquiring as many properties as possible, buying any unowned properties they can afford without hesitation. This aggressive acquisition approach allows players to quickly dominate the board and prevent competitors from securing valuable spaces. Additionally, the strategy encourages relentless property upgrades, regardless of the player's financial status. By maximizing their investments in both land acquisition and property improvements, players aim to generate high rent returns and establish a commanding presence in the game. This strategy thrives on risk-taking and aggressive resource management.




## Procedure
The experiment was conducted by simulating multiple games of Monopoly using four distinct player strategies: 
Collector, Cautious Saver, Disruptive, and Aggressive Buyer. 
Each simulation initialized players with a balance of $750 and started at position 0 on the board. 
The simulation ran for a maximum of 100 turns per game or until all but one player were eliminated. 
Metrics collected included the number of wins per strategy, average player balance, and properties owned. 
The board was initialized with predefined spaces, including properties, utilities, and special spaces like "Go to Jail." 
Player actions were determined by their respective strategies implemented via the Strategy interface. 
The experiment recorded metrics after each game and aggregated results for analysis.


## Results
The simulation tested four distinct strategies to assess their effectiveness in a competitive gameplay environment. The Collector Strategy emerged as the most successful, achieving 23 wins with moderate financial reserves and the highest average property ownership (2 properties). This strategy's focus on securing properties of a specific color proved to be an effective long-term winning approach.The Cautious Saver strategy secured only 10 wins, prioritizing financial stability over property acquisition. Its players maintained the highest average balance ($257), but the reluctance to invest in properties limited their competitive edge. The Disruptive Strategy, aiming to hinder opponents by acquiring diverse property colors, achieved 22 wins, nearly matching the Collector Strategy. However, players employing this strategy ended games with no balance and zero properties, indicating an all-or-nothing gameplay style that focuses on obstruction rather than wealth accumulation.Lastly, the Aggressive Buyer strategy had the lowest success rate, with only 5 wins. Despite its low victory count, it resulted in the highest average balance ($474) and emphasized continuous property upgrades. However, the lack of a focused property acquisition strategy likely hindered its effectiveness.The results highlight that strategies balancing investment with targeted goals—like the Collector Strategy—tend to perform best, while overly conservative or disruptive approaches yield mixed outcomes.








**Example Image:**

![Shiny Pokemon](img.png)

**Simulation Results Table**

| Strategy            | Wins | Average Balance | Average Properties Owned |
|---------------------|------|-----------------|--------------------------|
| Collector Strategy  | 23   | $131            | 2                        |
| Cautious Saver      | 10   | $257            | 1                        |
| Disruptive Strategy | 22   | $0              | 0                        |
| Aggressive Buyer    | 5    | $474            | 1                        |


## Analysis
The simulation results offer valuable insights into how different strategies perform in a competitive gameplay environment. Here, we analyze each strategy's strengths and weaknesses to explain why certain approaches are more effective than others, supported by the provided data. Collector Strategy – Most Effective (23 Wins)
The Collector Strategy emerged as the most effective approach, securing 23 wins, the highest among all strategies. Its players maintained an average balance of $131 and owned the most properties (2 on average). This strategy focuses on acquiring and upgrading properties of a specific color, creating a targeted approach that allows for a stable accumulation of income through rent. The relatively moderate balance suggests active investment in property upgrades, which contributed to its success. The strong focus on monopolizing specific property groups created consistent opportunities for generating revenue, supporting its dominance in the simulation.
Disruptive Strategy – Competitive but Risky (22 Wins)
The Disruptive Strategy closely followed with 22 wins. However, its players ended with a balance of $0 and no properties owned on average. This strategy prioritizes preventing opponents from completing monopolies by acquiring diverse property colors. While this approach effectively disrupts others, it appears to sacrifice financial stability and long-term property value. The lack of owned properties and balance indicates that this strategy operates on a high-risk, high-reward model, which is less sustainable. Nevertheless, the wins demonstrate its capability to interfere successfully with competitors and seize occasional victories.
Cautious Saver – Balanced but Limited (10 Wins)
The Cautious Saver strategy secured only 10 wins, indicating limited success. Its players maintained the highest average balance ($257) but owned only one property on average. This strategy's cautious nature ensures financial stability by maintaining a safety threshold for spending. While it prevents bankruptcy, it also limits investment in property acquisition and upgrades, critical factors for winning in this environment. Players following this strategy are less likely to build monopolies or generate high rent income, which directly impacted their lower win rate. Despite financial prudence, the lack of aggressive investment limited its competitive effectiveness.
Aggressive Buyer – Least Effective (5 Wins)
The Aggressive Buyer strategy recorded the lowest win count (5). Despite this, it achieved the highest average balance ($474), indicating that players often prioritized accumulating wealth over acquiring properties. With only one property owned on average, this strategy's lack of focus on completing monopolies significantly hindered its competitive performance. The data suggests that while aggressive purchasing can occasionally lead to wins, the absence of a structured property acquisition or upgrade plan limits its viability in the long term. Players often failed to leverage their high balance effectively.
Why the Collector Strategy Is Superior?
The success of the Collector Strategy lies in its balance between focused investment and long-term growth. The strategy's emphasis on monopolizing specific property colors maximizes rent revenue, while active upgrades ensure sustained financial returns. Its performance (23 wins, 2 properties owned) shows that targeted property acquisition outperforms risk-heavy approaches like the Disruptive Strategy or overly conservative ones like the Cautious Saver. By maintaining a balance between resource management and strategic investment, the Collector Strategy consistently outperformed its counterparts, making it the most effective and sustainable choice.
The Disruptive Strategy came close but proved less reliable due to its aggressive and unsustainable approach, while the Cautious Saver and Aggressive Buyer struggled due to their extremes of conservatism and reckless spending. This analysis demonstrates the importance of balanced, focused strategies in competitive gameplay.







# Reflection
_A reflection on your experiences with generative AI during this project. Provide a few sentences reflecting
on your experience with AI for each of the following prompts._ 

### What generative AI did you use, and what tasks did you use it for?
- **ChatGPT**: Assisted in code generation for specific classes and methods, including player actions and board initialization.
- **GitHub Copilot**: Provided suggestions for implementing game logic and debugging.


### How did you learn about the tools used by your group (delete ones that don't apply)?
_ **ChatGPT**: Discovered through peers.
- **GitHub Copilot**: Recommended by the lecturers through github and also through peers. 

### Reflecting on your experience:
How I Used Generative AI
Generative AI was instrumental in several aspects of this project, serving as both a creative partner and a problem-solving assistant. Specifically, I leveraged its capabilities for generating descriptive explanations, formatting data into tables and visual aids, and interpreting simulation results. For example, AI helped to succinctly explain complex strategies such as the Collector Strategy and Disruptive Strategy, presenting them in a way that was clear and concise while retaining their nuances. Additionally, the AI facilitated the creation of a polished simulation results table and provided detailed analysis, helping me to identify patterns and articulate the comparative performance of different strategies.
The AI was also invaluable in creating professional-level documentation, such as JavaDoc comments, which enhanced the readability and maintainability of the code. Its ability to consistently generate high-quality comments across multiple pieces of code allowed me to focus more on implementation and testing.
How Generative AI Enhanced My Work
The use of generative AI significantly improved the quality and efficiency of this project. By automating repetitive tasks, such as summarizing data and formatting explanations, AI allowed me to devote more time to strategy design and experimentation. It also ensured that my work maintained a professional standard, providing clarity and coherence in areas where manual writing could have introduced inconsistencies or errors. The AI's ability to synthesize information and generate well-structured content made the documentation and analysis components of the project smoother and more efficient.
Challenges and Limitations of Generative AI
While the AI was a powerful tool, there were certain challenges and limitations in its use. For instance, when generating strategy descriptions or reflections, the AI occasionally produced overly generic or redundant responses. This required additional effort on my part to refine the outputs to ensure they aligned closely with the project's objectives and conveyed meaningful insights. Furthermore, the AI's understanding of context occasionally led to suggestions or content that did not fully reflect the nuanced differences between strategies. These limitations underscored the importance of maintaining critical oversight when using AI-generated content.
Another limitation was that the AI did not participate in the actual execution or debugging of the simulation code. Its contributions were limited to assisting with explanations, formatting, and interpretation of results. This highlights the need for human expertise in technical and analytical tasks, as the AI was not capable of independently designing or running simulations.
Reflection on the Impact of AI on My Learning
Using generative AI in this project expanded my understanding of how to integrate technology into research and development processes. It also taught me the importance of balancing automation with critical thinking. While AI provided significant support in areas like documentation, analysis, and reflection, I had to ensure that the content was accurate, meaningful, and aligned with my project goals. This process deepened my appreciation for the role of AI as a collaborative tool rather than a replacement for human effort.
Final Thoughts
Overall, generative AI proved to be a valuable asset in this project. It enhanced my productivity, improved the quality of my work, and allowed me to focus on strategic and analytical tasks. However, its limitations reaffirmed the importance of human judgment and expertise, highlighting the need for a balanced approach to leveraging AI in academic and professional settings.

**Prompts to think about in writing your reflections if you worked with generative AI:**
What Went Well Using Generative AI in This Project?
Generative AI significantly streamlined various aspects of this project. It was particularly effective in tasks that required synthesizing and formatting information, such as creating well-structured descriptions of strategies and generating professional-quality documentation like JavaDoc comments. AI provided quick and coherent summaries, allowing me to focus more on the creative and analytical parts of the project. Additionally, its ability to identify patterns and provide interpretations of the simulation results was invaluable, helping to frame the findings in a compelling and organized manner.
The AI's suggestions often brought fresh perspectives to the data analysis, such as recognizing the implications of the Collector Strategy’s high win rate or why the Disruptive Strategy led to a low balance but still achieved significant wins. This enhanced the depth and clarity of the final interpretation. It also helped produce clear and professional tables, visual aids, and explanatory content, which added a polished and professional touch to the presentation.

What Didn’t Go Well Using Generative AI?
Despite its usefulness, generative AI sometimes produced overly generic or formulaic responses, particularly when interpreting data or explaining strategies. For example, while the initial drafts of descriptions and reflections were clear, they often lacked the depth or nuance required for this project. Additionally, AI occasionally misunderstood the specific context of certain strategies, leading to interpretations that did not fully align with their intended behavior.
Another challenge was ensuring that the AI-generated content was accurate and meaningful. For instance, while AI could summarize the simulation results, it required manual effort to validate its conclusions and adjust any misleading or incomplete statements.

Were There Any Limitations You Encountered Using Generative AI?
The AI’s primary limitation was its inability to actively participate in the technical aspects of the project, such as debugging or refining the simulation code. While it could assist with comments and documentation, it did not directly contribute to the design, execution, or debugging of the simulation itself. This reinforced the importance of human intervention in the coding process. Furthermore, the AI occasionally struggled to generate content that was specific to the unique dynamics of the strategies in the project, necessitating additional refinements on my part.
Another limitation was that the AI sometimes offered repetitive or redundant suggestions, especially in reflections and documentation. This required additional editing to ensure that the content was concise and non-repetitive.

How Did Your Solution Change/Evolve/Improve/Degrade Because of the Generative AI?
The use of generative AI improved the project by enhancing the quality and clarity of documentation, strategy descriptions, and data interpretations. AI-assisted formatting and analysis brought consistency and polish to the final deliverables, which would have been more time-consuming and error-prone without it. Additionally, it provided valuable suggestions for articulating the significance of the simulation results and the strengths and weaknesses of each strategy.
However, reliance on AI also required careful oversight to avoid overgeneralizations or inaccuracies in its outputs. The AI’s contributions evolved from being a passive assistant to an active collaborator, requiring iterative refinements to align with the project’s needs.

What Could You Have Done So the Project Turned Out Better?
To further improve the project, I could have invested more time in fine-tuning the prompts given to the AI to generate more specific and nuanced responses. Additionally, integrating a collaborative review process earlier in the project could have helped identify gaps or inconsistencies in AI-generated content more efficiently. A greater emphasis on testing and validating the AI's interpretations with real data from the simulations could have also enhanced the accuracy and depth of the analysis.
Overall, while generative AI was a valuable tool, balancing its use with human critical thinking and creativity was key to the project’s success.







# Bonus Consideration:
If you have aspects of your project you would like considered for the available bonus.
