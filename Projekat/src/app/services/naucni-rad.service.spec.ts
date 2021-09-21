import { TestBed } from '@angular/core/testing';

import { NaucniRadService } from './naucni-rad.service';

describe('NaucniRadService', () => {
  let service: NaucniRadService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(NaucniRadService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
