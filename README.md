dojo-terminal
=============

Code Dojo Task
--------------

A friend of yours owns a large area of land and he uses the land to rent the space to other companies. Your friend plans to refurbish the land in such a way that it can handle large containers. Companies can then rent a pre-defined space that fits exactly one 40-foot container. When a container arrives at the site, it will be moved to a free spot. When the container is handed over to its owner, the bill is calculated and the container is returned.Your friends needs you to write him a programme that keeps track of the available free space, the stored containers, and the billing.

Container handling
------------------

- The container terminal is 30 rows long and 30 rows wide and each cell on that grid refers to a space for one container
- Each container has a unique location and containers cannot be stacked upon each other
- Each container has an owner, but an owner can store as many containers as there is free space
- Containers stay at least one day, but can be stored for as many as the owner wishes

Billing
-------

- The cost for storage is 100 Euro per day per container
- After the container is returned, the bill is calculated and sent to the owner

Requirements
------------

- implement the container handling and billing
- furthermore, your friend always wants to know how many free spaces are still available (so the clients always know if they can store more containers or not)
- and most importantly, your friend always wants to know how much money he has still earned (in cash) and how much money can be made with the currently stored containers
