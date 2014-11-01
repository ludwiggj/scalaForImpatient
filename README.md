refactoringMovies
=================

This is a worked refactoring exercise, based on the [refactoring movies example](http://www.slideshare.net/liufabin66688/refactoring-example) by Sherif Ghali.

# Getting the Initial Code #

The code for this example is available from the [refactoring movies git repo](https://github.com/ludwiggj/refactoringMovies.git):

* You can download and install [git](http://git-scm.com/downloads), and then use [git clone](https://www.atlassian.com/git/tutorials/setting-up-a-repository/git-clone) to download the code.

* Another option is to get the code via your [IDE](http://en.wikipedia.org/wiki/Integrated_development_environment). Most IDEs have git functionality built in, or available via a plug-in.

* You can also use a stand-alone git client. For example, [Atlassian SourceTree](https://www.atlassian.com/software/sourcetree/overview) is very good, and free!

# Working With the Code #

Each significant step in refactoring the code base is represented by a separate commit, and is [tagged](http://git-scm.com/book/en/v2/Git-Basics-Tagging) as follows:

* **Start**  
This commit i.e. the initial starting point of the code.  
See **README_Start.md** (in this directory) for a description of the initial state of the code in this commit, before refactoring begins.
 
* **Step01**  
The code after the first round of refactoring.  
See **README_Step01.md** for an explanation of the refactoring changes that have been made in this step, and the reasoning behind them.

* **StepN**  
See **README_StepN.md** for an explanation of the refactoring changes that have been made in this step, and the reasoning behind them.

After cloning the code you can move to a specific step in the refactoring process by checking out the relevant tag e.g. to move from Start to Step01 from the git command line:

    git checkout Step01

Coming Next...
============== 

Each read me file concludes with a **coming next** feature, which summarises the refactoring to be tackled in the next step. You may choose to have a go at the suggested refactoring yourself before fetching the next commit.

Graeme Ludwig, 31/10/14.