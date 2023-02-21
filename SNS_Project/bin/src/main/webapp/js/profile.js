const tapContainer = document.querySelector('.about');
const flex_Container = document.querySelectorAll('.contents_container');
const taps = document.querySelectorAll('.about > span');
document.addEventListener('DOMContentLoaded', function() {
    console.log('flex_Container length:', flex_Container.length);
    console.log('taps length:', taps.length);
    tapContainer.addEventListener('click', openCity);
});


function openCity(evt) {
    var i;
    var elem = evt.target;
    console.log('elem:', elem);
    console.log('flex_Container:', flex_Container);
    console.log('taps:', taps);

    for (var i = 0; i < flex_Container.length; i++) {
        flex_Container[i].classList.remove('active');
        taps[i].classList.remove('on');
    }

    if(elem.matches('[class="nick_name"]')){
        flex_Container[0].classList.add('active');
        taps[0].classList.add('on');
    } else if(elem.matches('[class="boardBookMark"]')){
        flex_Container[1].classList.add('active');
        taps[1].classList.add('on');
    } else if(elem.matches('[class="shortsBookMark"]')){
        flex_Container[2].classList.add('active');
        taps[2].classList.add('on');
    }
}
console.log('flex_Container length:', flex_Container.length);
console.log('taps length:', taps.length);

tapContainer.addEventListener('click', openCity);