self.addEventListener('install', function(event) {
  event.waitUntil(
    caches.open('v1')
  );
});

self.addEventListener("fetch", function (event)  { 
    event.waitUntil(update(event.request)); //TODO: refresh
  });
  



function update(request) {
    return fetch(request.url).then(
      response =>{ 
        let responseClone = response.clone();
        caches.open('v1').then(function(cache){  cache.put(request.url, responseClone); return  response}); // we can put response in cache
        
      } 
    ).catch(function () {
      return caches.match(request.url);
    });
  }
  
 
  