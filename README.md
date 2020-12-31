
### bug1 
#### fragment lifecycle method error when use navigation with BottomNavigationView
Here is what I want:

![Image](https://github.com/keluokeda/navigation_bug/blob/master/images/Screenshot_20201231_153725_com.ke.navigation_bug.jpg)

Statusbar should hide when HomeFragment show and show when HomeFragment hide,so I do this in HomeFragment

```
 override fun onResume() {
        super.onResume()
        setTranslucentStatus(true)
        mainViewModel.add("onResume $this")
    }

    override fun onPause() {
        super.onPause()
        setTranslucentStatus(false)
        mainViewModel.add("onResume $this")

    }
```
it looks well,but when user tap home menu again,Statusbar is showing!
![Image](https://github.com/keluokeda/navigation_bug/blob/master/images/SVID_20201231_155844_1.2020-12-31_15_59_56.gif)

So I print Fragment lifecycle method,I found fisrt call new HomeFragment onResume then call old HomeFragment onPause!

### bug2
#### create new ViewModel when click home menu again

when user tap home menu again,I found a new Viewmodel created,I think there is no necessary to create a new one.
