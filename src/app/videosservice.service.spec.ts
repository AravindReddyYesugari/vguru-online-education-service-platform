import { TestBed } from '@angular/core/testing';

import { VideosserviceService } from './videosservice.service';

describe('VideosserviceService', () => {
  let service: VideosserviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(VideosserviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
