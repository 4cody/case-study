# What #
Case study to demonstrate the skills and technologies learned during a 10 week training with TEKsystems.
We are learning Java and Spring MVC

# Project Title #
#### Cedar Drone

# Idea #
The website is for drone/quad copter reviews.  It's target audience would be drone enthusiasts and those in the market for a drone.  The value here is for community of people to have a place to congregate online and exchange ideas and discuss all things drone.  This is the ideal.  For the purpose of the project with the given time and requirements, I will be focusing on the functionality needed to create users and for those users to be able to leave reviews on a given drone.  These drone "veiws" should have a specs table and their reviews should be by visible. 

# User Stories #
- As a User I want to be able to leave reviews on drones to inform others aboout a specific model
- As a Consumer I want to be able to view drone specs and reviews in order to make an informed buying decision
- As a User I want to be able edit or delete my review from a drone so that I can keep information up to date
- As a User I want to be have the ability to see all reviews I've left so I can easily find and edit a given review
- As a developer I want to prevent users from leaving multiple reviews on a single drone to prevent spam
- As a web site/platform I want to be able to store user ratings on a given drone in order to have a air of authority in the space

## Technologies Used 
- Java 
- SQL
- Spring MVC
- JSP/JSTL
- Spring Data JPA
- HTML/CSS/JavaScript

## Road-Blocks and Issues ##
While getting back-end functionality working I ran into a few notable hurdles.  The first of which was passing data between controller methods, in particular passing the drone information along when a user leaves a review.  I have to still tie in the user information to a review but for the sake of progress and time, for now I will just have a drone ID attached to a review.  

I was having trouble getting Spring data JPA to create and save the relationships in the data base ; ie when a user leaves a review on a given drone the review would save but a relationship record wouldn't be created.  As a work around I attempted to do this all manually by creating the review row and using other data to create a relationship row (drone_review)and this all deteriorated rather quickly.  After some guidance I resloved to change how my entities were related to eachother which very well may have been the root cause to begin with, and was able to have a drone store a list of reviews.  The ideal component of this would be to have a user store a list of reviews they've left on drones, or to incorporate the user ID in the review to prevent multiple reviews on the same drone from a single user.  The user should only be able to edit their review.

While working on full crud functionality I ran into a problem when trying to work out a review being deleted,  "Cannot delete or update a parent row: a foreign key constraint fails" and I've come to understand this error is occuring due to the reviews being owned by the drone entity in a 'reviews list'.  To remedy this I need to re-design how the entites relate to one another, specifcally removing the current relationship of a review to it's respective drone.  A differnt approach I would take would keep the drone, review and user records indedpendent and have an aggregate table that stores a composite key every time a review is create that is comprised of the 3 respective primary keys. 


# Front End # 


This site map that was mostly adhered to with slight changes during development.

[![Site-map.png](https://i.postimg.cc/6qCcSXrb/Site-map.png)](https://postimg.cc/H8sbcFPb)

# Backend #

## DataBase ##
This project is using SQL for it's database.

[![db-map-02.png](https://i.postimg.cc/MTpk6kjP/db-map-02.png)](https://postimg.cc/94KgbnbZ)

# Dev Blog #

Early on in the training when we were first made aware about a cap-stonesque project I was wavering between a couple ideas.  My considerations were in regards to whether or not I could feasibly develop the project in the given amount of time and how I could come up with an idea to meet the requirments.

Little thought was put in to this for the first few weeks as I had no reference point for the effort and time that would be required to develop within the (at the time) to be learned technologies.  I settled with a vague notion to build "a drone website" to appease some deadlines for having an idea and went along beginning to learn the course content. 

In the first 8 weeks I payed very little to no attention to the case-study as the class was moving very rapidly through learning Java SQL and some peripheral tools and technologies.  It would have been a fruitless endeavor to try and implement anything on a case study project when I was doing bite sized test projects daily on the given content, most of the time in a vacuum.  As it were, the isolated concepts were not fitting together to make meaningful progress on a project that was to be "full-stack" in scope, and so I opted to spend effort understanding what was being delivered as it came instead of laboring on my case study.  

In week 8 is when I started to think about the database design for the project and came up with the minimum 4 tables I would need to meet a technical requirment.  This was a short lived jaunt as the introduction of Spring seemed to increase the complexity of what we were doing and the pace of subject content seems to increase in kind.  

It's the end of week 9 and Alas! I've spent no more time on my case-study but have gained a level of comfort with what we began to learn, with emphasis on getting data from a client in jsp and getting it to my backend and stored in a db.  The current focus is retrieving data from the db and displaying it to the user.  I'm struggling with the moving parts of SpringMVC yet and how it's all fitting together, monkey see monkey do at this point.  Don't ask me the about the "why's" just yet.  

As I've started to add the skeleton files that I know I'll need and build out some of the folder structure I'm thinking I'll need, I realized that I am just doing what I've always done when attempting a project.  I just start coding.  I've decided to back up a little bit and give myself a greater foundation with more planning.  The idea I have is enough to go off of but I havn't taken the time to design things before building.. and this isn't the SDLC way.  I'm going to start with writing user stories that would get me to an MVC, from there I will design some from end wire frames.  I think with these things and the database mapped out I could start implementation and revist these particulars as needed.

Much of what is done and being turned in was a bit of a scramble to make the deadline.  I will have to address some styling for the presentaion that won't be in the 'final turn in' for a grade.  I've ran into a number of unforseen issues that seem to arise from a poor program design on my part..  Live and learn..