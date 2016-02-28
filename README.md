# Idea
A way of automating tasks using a as-simple-as-possible programming language to make it easy, but that provides a more powerful system than IFTTT

# Examples
```
if  ( I posted a photo to instagram ) then
    post that to facebook
    save that to google drive
    mark that as done
    let myNumber be the count of my instagram photos
    let days be the number of days since my instagram account opened
    email me with "Average photos per day = " + myNumber / days
``` 

# Implementation Ideas
keywords like: `if` or `that`
set nouns like: `posted a photo to instagram`
actions like: `count` and `email`

For example:
 * `post that to facebook` would be Action ( name = post, what = that (Instagram photo), where = facebook)
 * `let myNumber be the count of my instagram photos` would be Set ( name = myNumber, what = Action ( name = count, what = instagram photos ) )
=======
# AutoLang
A simple programming language designed to be more like English
