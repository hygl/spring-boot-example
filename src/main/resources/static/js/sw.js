self.addEventListener("fetch", function (event)  { 
    event.respondWith(caches.match(event.request));
    event.waitUntil(update(event.request)); //TODO: refresh
  });
  



function update(request) {
    return fetch(request.url).then(
      response =>
        cache(request, response) // we can put response in cache
          .then(() => response) // resolve promise with the Response object
    );
  }
 
  