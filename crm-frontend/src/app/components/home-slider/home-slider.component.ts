import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home-slider',
  templateUrl: './home-slider.component.html',
  styleUrls: ['./home-slider.component.css']
})
export class HomeSliderComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }
 imageObject: Array<object> = [{
    image: 'assets/a.jpg',
    thumbImage: 'assets/a.jpg',
    alt: 'alt of image',
    title: 'title of image'
}, {
    image: 'assets/a.jpg', // Support base64 image
    thumbImage: 'assets/a.jpg', // Support base64 image
    title: 'Image title', //Optional: You can use this key if want to show image with title
    alt: 'Image alt' //Optional: You can use this key if want to show image with alt
}
, {
  image: 'assets/a.jpg', // Support base64 image
  thumbImage: 'assets/a.jpg', // Support base64 image
  title: 'Image title', //Optional: You can use this key if want to show image with title
  alt: 'Image alt' //Optional: You can use this key if want to show image with alt
}
, {
  image: 'assets/a.jpg', // Support base64 image
  thumbImage: 'assets/a.jpg', // Support base64 image
  title: 'Image title', //Optional: You can use this key if want to show image with title
  alt: 'Image alt' //Optional: You can use this key if want to show image with alt
}
, {
  image: 'assets/a.jpg', // Support base64 image
  thumbImage: 'assets/a.jpg', // Support base64 image
  title: 'Image title', //Optional: You can use this key if want to show image with title
  alt: 'Image alt' //Optional: You can use this key if want to show image with alt
}
, {
  image: 'assets/a.jpg', // Support base64 image
  thumbImage: 'assets/a.jpg', // Support base64 image
  title: 'Image title', //Optional: You can use this key if want to show image with title
  alt: 'Image alt' //Optional: You can use this key if want to show image with alt
}
, {
  image: 'assets/a.jpg', // Support base64 image
  thumbImage: 'assets/a.jpg', // Support base64 image
  title: 'Image title', //Optional: You can use this key if want to show image with title
  alt: 'Image alt' //Optional: You can use this key if want to show image with alt
}

];

}
