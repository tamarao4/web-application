import { TestBed } from '@angular/core/testing';

import { KljucneReciService } from './kljucne-reci.service';

describe('KljucneReciService', () => {
  let service: KljucneReciService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(KljucneReciService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
