<template>
  <a class="explore-item" @click="toTagPage">
    <div>
        <img v-if="tagcount == 0" v-bind:src="img" >
        <img v-else v-bind:src="tagimg">
        <div>
            <div>{{tagcount>0?'#':''}}{{name}}</div>
            <span v-if="tagcount > 0" >{{tagcount}}作品</span>
        </div>
    </div>
  </a>
</template>

<script>
export default {
  data() {
      return {
          tagimg: 'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAOEAAADhCAMAAAAJbSJIAAAAe1BMVEX///8AAABhYWEiIiI8PDxwcHD5+fnm5uZVVVWxsbH7+/vAwMC0tLSnp6cyMjLc3NxpaWmLi4uenp7V1dXw8PDi4uK6uronJyd1dXURERFFRUUfHx9kZGRYWFgtLS3y8vJ/f3/IyMiVlZVOTk4YGBjOzs43NzeDg4OampqIga0kAAAEGklEQVR4nO2d21IbMRBEWV8W2ICBYPAFgjcYTP7/C1N5U1fRzoBApVb1eZ5yzVhuaaQZyScnxhhjjDHGGGOMMcYYY4wxxhhjjDHGGGOMMcYYY4wxxhhjjKmToU9hViGjStl2CRNidJoadadFHcwGfD8nRpep0aGof9nchkZnnhrdFHUwGxidKbOCr+FHSf/y+ZX6viZGdxDhUNTBXPrVh2X4VNTBbK5CMpy0IsMDW+mUZfiY+j4nRjjfai34/VPq+wWxgoHeFnUwG5wkr4gVzLfKMmSTJM63v4s6mM069f2aGKEMl0UdzOYl9f2eGP1MjfZF/csGtwx3xArm27eiDmZznvq+IUa7qbAMYcvAVsNY2lMp4DtbDf+kRrOi/mWDMmSTpLIML1LfX4jRAF+DWFIKMhyJkfRqCJMk2xvCargq6l82V6HR2adGYknpfer7gZ1NNCNDdkTzChHuijqYzSz1na2GIEOxIxrcG7JcBY7ElWXIcpWdsgzH1HeWlKIMtVbDAWTI9obPqZHYEc0SRoftDWE1HAu69wWADFmustwIy/At9T22GortDZ8iowMyrO+IZvIyPQKMzsP7NnCM2G1W7KNYuvDdnHWlYPsSR+gIHaEjdISO0BE6wnz2/3dNPMKbOQP6Y7rJ+0ZrKJ9u1/TT5tf1ldygYDElJ6X9Q2p1W9bDXKB8f0aMlI9osHx/SYyeI19DpWDdkP3+mumi6YgRHtG8FnUwm+vU91/EKNY8XCnge0iGYielWDdkzWzKPaXQRcNkiOX7+pb0o8DoxJrZxOqGodVQuW6IoxMqWIjJEG9YtNjaDTJsv7WbyRAGelHUwWxwNWxRhjBJLsjvb1CuG0JS2mJrdw+rYeiiU/tJ6VjQvS8AZPhAjHahAnGlhJLSdlq7W5ThJ679sj6NSgEZsr0hnpSKyXAfGR3sWmRpT6WA76yZrfKk9HQ14ywgwgWxgh/phn4Yvdv+3RF2xXCEjtAROkJH6AgdoSN0hJ9meTZ5n0fsIHokZnBSNWNW/6iveyF0w2KAtFusfA9dNOwcu53yfeiGhdgRDU5BrJykXL6HZja2c5cu34fezZMu38M9oNBbNPUd0RzlE7fvn4s6mA3IkE6SyjKEuuFIjFCGWg8kDofUd7YaKhcsYrfvlWV4HhkdLN+LyRCS0pEYKa+GQ6iqC6thfZujo8Qec26mtZu1GuLLbMp7w5EYQdqz0eqiidUN23kgkU2SkPaIyTD0QGLfzA0L9m5ebPdRKR+XodgDibHRgQcSlZNS+tcG8DWIJaWh5ysxKS3qXz6QlIa6aKRlGEpKlWW4DT2QKCZDWA1ZM5vyEU0PvV4hGYrtDWOthsoyDLUa9sp7w9Cr3co3LIwxxhhjjDHGGGOMMcYYY4wxxhhjjGmAvxsWN4Ktr7TCAAAAAElFTkSuQmCC',
      }
  },
  props:['img','name','tagcount'],
  mounted() {
  },
  methods: {
      toTagPage() {
          if ( this.tagcount > 0 ) {
              this.$router.push("/tag/"+this.name)
          } else {
              this.$router.push("/user/"+this.name)
          }
      }
  }
}
</script>