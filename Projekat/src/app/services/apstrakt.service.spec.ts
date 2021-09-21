import { TestBed } from '@angular/core/testing';

import { ApstraktService } from './apstrakt.service';

describe('ApstraktService', () => {
  let service: ApstraktService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ApstraktService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
